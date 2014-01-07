/*
* Copyright (c) 2000~2013  Samsung Electronics, Inc.
* All rights reserved.
*
* This software is the confidential and proprietary information
* of Samsung Electronics, Inc. ("Confidential Information").  You
* shall not disclose such Confidential Information and shall use
* it only in accordance with the terms of the license agreement
* you entered into with Samsung Electronics.
*/

package com.samsung.surc.swtest.users;

import com.samsung.surc.swtest.Maze;
import com.samsung.surc.swtest.MazeSolver;
import com.samsung.surc.swtest.User;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class DmytroKolomiyets implements MazeSolver {

    private final static boolean ISDEBUG = false;

    @Override
    public int solve(Maze maze) {
        try {
            Cell entrance = getEntracneCell(maze);
            if(maze.isWall(entrance.x, entrance.y)) throw new NoPathException();
            Cell exit = getExitCell(maze);
            if(maze.isWall(exit.x, exit.y)) throw new NoPathException();
            int stepsCount = 0;

            Cell current = entrance;
            Stack<Cell> path = new Stack<Cell>();
            ArrayList<Cell> blackList = new ArrayList<Cell>();

            path.push(new Cell(current.x, current.y));

            while (current.x!=exit.x || current.y!=exit.y){

                stepsCount++;

                ArrayList<Cell> nextSteps = getNextSteps(current, maze);
                if(nextSteps.isEmpty()) {
                    blackList.add(new Cell(current.x, current.y));
                    current = getPreviousStep(path);
                    continue;
                }

                Cell nextCandidate = getOptimalStep(nextSteps, exit, path, blackList);
                if(nextCandidate == null) {
                    blackList.add(new Cell(current.x, current.y));
                    current = getPreviousStep(path);
                    continue;
                }

                cutPathLoop(nextCandidate, path, blackList);

                current = nextCandidate;
                path.push(new Cell(current.x, current.y));
            }

            if(ISDEBUG){
                StringBuilder log = new StringBuilder();
                log.append("finished in "+stepsCount+++" iterations\n");
                log.append("the optimal path:\n");
                for(Cell cell: path){
                    log.append("["+cell.x+","+cell.y+"];\n");
                }

                System.out.println(log.toString());
            }

            return path.size()-1;
        } catch (NoPathException e) {
            return -1;
        }
    }

    private void cutPathLoop(Cell next, Stack<Cell> path, ArrayList<Cell> blackList){
        for(int i=0; i<path.size(); i++){
            if(isNeighbor(next, path.get(i))){
                while (path.size()>i+1){
                    blackList.add(path.pop());
                }
            }
        }
    }

    private boolean isNeighbor(Cell left, Cell right){
        return Math.abs(left.x - right.x)<=1 && Math.abs(left.y - right.y)<=1;
    }

    private Cell getPreviousStep(Stack<Cell> path){
        path.pop();
        if(path.isEmpty()) throw new NoPathException();
        return new Cell(path.peek().x, path.peek().y);
    }

    private boolean isInPath(Cell nextCandidate, Stack<Cell> path){
        for(Cell pathStep : path){
            if(nextCandidate.x==pathStep.x && nextCandidate.y==pathStep.y){
                return true;
            }
        }
        return false;
    }

    private boolean isInBlackList(Cell nextCandidate, ArrayList<Cell> blackList) {

        for(Cell badStep : blackList){
            if(nextCandidate.x == badStep.x &&
                    nextCandidate.y == badStep.y){
                return true;
            }
        }

        return false;
    }

    private ArrayList<Cell> getNextSteps(Cell current, Maze maze){
        ArrayList<Cell> result = new ArrayList<Cell>();

        for(int y=-1; y<=1; y++){
            for(int x=-1; x<=1; x++){
                if(x==0 && y==0) continue;

                int nextX = current.x + x;
                int nextY = current.y + y;
                if((nextX>=0 && nextY>=0 && nextX<maze.getWidth() && nextY<maze.getHeight()) && !maze.isWall(nextX, nextY)){
                    result.add(new Cell(nextX, nextY));
                }
            }
        }

        return result;
    }

    private ArrayList<Cell> getOptimalStep(ArrayList<Cell> nextSteps, Cell exit, Stack<Cell> path, ArrayList<Cell> blackList){
        double minWeight = Double.MAX_VALUE;
        ArrayList<Cell> result = new ArrayList<Cell>();
        for (Cell current : nextSteps){
            double weight = calculateWeight(current, exit);
            if(weight < minWeight
                    && !isInPath(current, path)
                    && !isInBlackList(current, blackList)){
                minWeight = weight;
                result = new ArrayList<Cell>();
                result.add(new Cell(current.x, current.y));
            } else if(weight == minWeight){
                result.add(new Cell(current.x, current.y));
            }
        }
        return result;
    }

    private double calculateWeight(Cell current, Cell exit){
        double dx = exit.x - current.x;
        double dy = exit.x - current.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public User getUserInfo() {
        return new User() {
            @Override
            public String getMySingleId() {
                return "d.kolomiyets";
            }

            @Override
            public String getName() {
                return "Dmytro";
            }

            @Override
            public String getSurname() {
                return "Kolomiyets";
            }
        };
    }

    public static class MyMaze implements Maze {

        final int[][] board;

        public MyMaze(int[][] board){
            this.board = board;
        }

        @Override
        public int getWidth() {
            return board[0].length;
        }

        @Override
        public int getHeight() {
            return board.length;
        }

        @Override
        public boolean isWall(int x, int y) {
            if(x<0||x>=getWidth()||y<0||y>=getHeight()) return true;
            return board[y][x] != 0;
        }
    }

    public Cell getEntracneCell(Maze maze){
        return new Cell(0, 0);
    }

    public Cell getExitCell(Maze maze){
        return new Cell(maze.getWidth()-1, maze.getHeight()-1);
    }

    public static class Cell{
        final int x;
        final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class NoPathException extends IllegalStateException {

    }
}
