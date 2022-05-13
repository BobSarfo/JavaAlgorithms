package com.algorithms.problems;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
    public static int bowling_score(String frames) {
        System.out.println(frames);
        String isStrike = "X";
        String isSpare = "/";
        List<Frame> frameList = new ArrayList<>();

        Frame head = new Frame();
        String[] games = frames.split(" ");

        for (int i = 0; i < games.length; i++) {
            var gameFrame = new Frame();
            String game = games[i];
            for (int j = 0; j < game.length(); j++) {
                if (i >= 9) i = i + j;
                var c = String.valueOf(game.charAt(j));

                if(i>=9){
                    if (c.equals(isStrike)) {
                        if (j == 0) gameFrame.firstRollIsStrike= true;
                        if (j == 1) gameFrame.secondRollIsStrike = true;
                        if (j == 2) gameFrame.thirdRollIsStrike = true;
                    }
                    if (c.equals(isSpare)) {
                        if (j == 1) gameFrame.secondRollIsSpare = true;
                        if (j == 2) gameFrame.thirdRollIsSpare = true;
                    }
                }
                if (c.equals(isStrike)) {
                    gameFrame.isStrike = true;
                }else if (c.equals(isSpare)) {
                    gameFrame.isSpare = true;
                }else{
                if (j == 0) gameFrame.firstRoll = Integer.parseUnsignedInt(c);
                if (j == 1) gameFrame.secondRoll = Integer.parseUnsignedInt(c);
                if (j == 2) gameFrame.thirdRoll = Integer.parseUnsignedInt(c);
                }

            }
            head.nextGame=gameFrame;
            head = head.nextGame;
            frameList.add(gameFrame);

        }

        int total = 0;
        int i=1;
        for(var frame : frameList){

            if(i==9){
                if(!frame.isStrike && !frame.isSpare){
                    frame.score = frame.firstRoll+ frame.secondRoll;
                    total+=frame.score;
                }

                if(frame.isSpare){
                    int addedScore = 0;
                    if(frame.nextGame.firstRollIsStrike) addedScore = 10;
                    else addedScore=frame.nextGame.firstRoll;
                    frame.score = 10+ addedScore;
                    total+=frame.score;
                }
                if (frame.isStrike){
                    int firstAddedScore = 0;
                    int secondAddedScore = 0;

                    if(frame.nextGame.firstRollIsStrike){
                        firstAddedScore = 10;
                        if(frame.nextGame.secondRollIsStrike) secondAddedScore= 10;
                        else if(frame.nextGame.secondRollIsSpare){
                            firstAddedScore=0;
                            secondAddedScore = 10+ frame.nextGame.thirdRoll;
                        }
                        else secondAddedScore=frame.nextGame.secondRoll;
                    }
                    else  {
                        firstAddedScore = frame.nextGame.firstRoll;
                        if(frame.nextGame.secondRollIsSpare){
                            firstAddedScore=0;
                            secondAddedScore=10;

                        }
                        else secondAddedScore = frame.nextGame.secondRoll;
                    }
                    frame.score = 10 + firstAddedScore + secondAddedScore;
                    total+=frame.score;

                }i++;
                continue;
            }
            if(i==10){
                if(!frame.firstRollIsStrike && !frame.secondRollIsStrike && !frame.secondRollIsSpare){
                    frame.score = frame.firstRoll+ frame.secondRoll;
                    total+=frame.score;
                    continue;
                }

                if (frame.firstRollIsStrike){
                    int firstAddedScore = 0;
                    int secondAddedScore = 0;

                    if(frame.secondRollIsStrike){
                        firstAddedScore= 10;
                        if(frame.thirdRollIsStrike) secondAddedScore=10;
                        else secondAddedScore = frame.thirdRoll;
                    }
                    else  {
                        firstAddedScore = frame.secondRoll;
                        secondAddedScore = frame.thirdRoll;
                        if(frame.thirdRollIsStrike) secondAddedScore = 10;
                        if (frame.thirdRollIsSpare){
                            firstAddedScore=0;
                            secondAddedScore=10;
                        }
                    }
                    frame.score = 10 + firstAddedScore + secondAddedScore;
                    total+=frame.score;

                }else{
                    int addedScore = 0;
                    if(frame.secondRollIsSpare){
                        addedScore = 10+ frame.thirdRoll;
                        if(frame.thirdRollIsStrike) addedScore = 10+10;
                        frame.score = addedScore;
                        total+=frame.score;
                    }
                    else {addedScore = frame.secondRoll;
                        frame.score = frame.firstRoll+addedScore;
                        total+=frame.score;
                    }
                }

                i = i + 1;
                break;

            }


            if(!frame.isStrike && !frame.isSpare){
                frame.score = frame.firstRoll+ frame.secondRoll;
                total+=frame.score;
            }

            if (frame.isStrike){
                int firstAddedScore = 0;
                int secondAddedScore = 0;

                if(frame.nextGame.isStrike){
                    firstAddedScore = 10;
                    if(frame.nextGame.nextGame.isStrike) secondAddedScore= 10;
                    else secondAddedScore=frame.nextGame.nextGame.firstRoll;
//                    //todo
//                    if(!frame.nextGame.nextGame.firstRollIsStrike) secondAddedScore=frame.nextGame.nextGame.firstRoll;
                }
                else if(frame.nextGame.isSpare){
                     secondAddedScore = 10;
                }
                else  {
                    firstAddedScore = frame.nextGame.firstRoll;
                    secondAddedScore = frame.nextGame.secondRoll;
                }
                var a = 10 + firstAddedScore + secondAddedScore;
                frame.score = a;
                total+=frame.score;

            }

            if(frame.isSpare){
                int addedScore = 0;
                if(frame.nextGame.isStrike) addedScore = 10;
                else addedScore=frame.nextGame.firstRoll;
                frame.score = 10+ addedScore;
                total+=frame.score;
            }

            i++;
        }
        return total;
    }

    static class Frame{
        int firstRoll;
        int secondRoll;
        int thirdRoll;
        int score;
        Frame nextGame= null;
        boolean isStrike=false;
        boolean isSpare=false;
        //last frame stats
        boolean firstRollIsStrike;
        boolean secondRollIsSpare;
        boolean secondRollIsStrike;
        boolean thirdRollIsSpare;
        boolean thirdRollIsStrike;

    }
}
