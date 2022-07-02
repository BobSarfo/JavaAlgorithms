package com.algorithms;


import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        var logs = GetAllLogLinesList();
        
        var transactions = logs.stream()
                .filter(x->
                        (x.description.toLowerCase().contains("transaction") &&
                        x.description.toLowerCase().contains("begin"))||
                                ( x.description.toLowerCase().contains("transaction") &&
                                        x.description.toLowerCase().contains("end")))
                .map(x-> {
                    var split = x.description.split(" ");
                    var transact = new Transaction();
                    transact.time = x.time;
                    if(split[0].equals("end"))
                    {
                        transact.Id = Integer.parseInt(split[2]);
                        transact.state = "end";

                    }
                    if(split[2].equals("begin"))
                    {
                        transact.Id = Integer.parseInt(split[1]);
                        transact.state = "begin";
                    }
                  return transact;
                }).collect(Collectors.toList());



        var fastestTime = Long.MAX_VALUE;
        var len = transactions.size();
        var currentTransaction = transactions.get(0);
        var fastestTransactionId = 0;

        var transactionInProgress= false;
        var error = 0;
        var totalTransactionTime = 0;
        for (int i = 1; i < len; i++) {
            var next = transactions.get(i);
            //check for accurate sequential transactions
            if(currentTransaction.state == "begin")
                transactionInProgress=true;
            if(currentTransaction.state == "end")
                transactionInProgress=false;
            if(next.Id!=currentTransaction.Id && transactionInProgress)
            {
                error+=1;
            }

            long diff = Duration.between(currentTransaction.time, next.time).getNano() / 1000000;


            if(diff<fastestTime &&!transactionInProgress){
                fastestTransactionId = currentTransaction.Id;
                fastestTime=diff;
            }
            if(!transactionInProgress)
            {
                totalTransactionTime+=diff;
            }

            currentTransaction = next;
        }

        System.out.println(totalTransactionTime/len);;
    }

    static class Transaction {
        public String state;
        public int Id;
        public LocalTime time;

        public Transaction(){}
        public Transaction(String state, int id) {
            this.state = state;
            Id = id;
        }
    }
    static class LogLine {
        public LocalDate date;
        public LocalTime time;
        public String logLevel;
        public int Num1;
        public int Num2;
        public String description;

        public LogLine(String dateTime, String logLevel, String num1, String num2, String description) {
            var dateSplit = dateTime.split(" ");
            this.date = LocalDate.parse(dateSplit[0], DateTimeFormatter.ofPattern("dd-M-yyyy"));
            this.time = LocalTime.parse(dateSplit[1], DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
            this.logLevel = logLevel;
            Num1 = Integer.parseInt(num1);
            Num2 = Integer.parseInt(num2);
            this.description = description;
        }
    }

    public static List<LogLine> GetAllLogLinesList() {
        List<LogLine> loglines = new ArrayList<>();
        try {
            List<String> filecontent = Files.readAllLines(Path.of("src/com/algorithms/exam.log"));

            for(String line :filecontent){
                var lineSplit = line.split("\t");
                LogLine logline =
                        new LogLine(lineSplit[0], lineSplit[1], lineSplit[2],lineSplit[3],lineSplit[4]);
                loglines.add(logline);
            }

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return loglines;
    }
}
