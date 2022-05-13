package com.algorithms.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Routes {
    public static String findRoutes(ArrayList<ArrayList<String>> routes) {
        ArrayList<City> cities = new ArrayList<>();
        City head=null;
        for (ArrayList<String> route: routes) {
            var a = new City(route);
            cities.add(a);
        }
        int max = Integer.MIN_VALUE;
        for (City first: cities) {
            int dist = 0;
            for (City second: cities) {
                dist=+1;
                if(Objects.equals(first.last, second.first)){
                    first.setNext(second) ;
                    if(head==null) head=first;
                    if(dist>max&&first.first!=head.first && first.last!=head.last){
                        max=dist;
                        head = first;
                    }
                }
                if(Objects.equals(first.first, second.last)){
                    first.setPrev(second);
                    if(head==null) head = first;
                }
            }
        }
        String results="";
        int maxc = 0;
        int count = 0;
        for(var hh :cities){
            City curr = hh;
            ArrayList<String> citiesResult = new ArrayList<>(curr.cities);
            while(curr!=null){
                count++;
                curr = curr.getNext();
                if (curr!=null)citiesResult.addAll(curr.cities);

            };
            if(count>maxc){
                results = citiesResult.stream().distinct().collect(Collectors.joining(", "));
                maxc=count;
            }

            count=0;

        }
        return results;
//        return String.join(", ", m);


    }
    public static class City{
        String first;
        String last;
        ArrayList<String> cities;
        private City next = null;
        private City prev = null;
        int count=0;

        public void setNext(City next) {
            this.next = next;
            count++;
        }

        public City getNext() {
            return next;
        }

        public void setPrev(City prev) {
            this.prev = prev;
        }

        public City(ArrayList<String> cityValues){
            assert cityValues != null;
            int len = cityValues.size();
            if(len<1) throw new RuntimeException();
            first = cityValues.get(0);
            last = cityValues.get(len-1);
            cities = cityValues;
        }

    }
}