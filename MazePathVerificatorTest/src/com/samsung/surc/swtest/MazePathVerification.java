package com.samsung.surc.swtest;

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

import org.reflections.Reflections;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MazePathVerification {

    public static void main(String[] args) {
        final long[] executionTime = {0};
        Reflections reflections = new Reflections("com.samsung.surc.swtest.users");
        Set<Class<? extends MazeSolver>> subTypesOf = reflections.getSubTypesOf(MazeSolver.class);
        for (final Class<? extends MazeSolver> mazeSolverClass : subTypesOf) {
            try {
                final MazeSolver mazeSolver = mazeSolverClass.newInstance();
                final User userInfo = mazeSolver.getUserInfo();
                Mazes[] mazes = Mazes.values();
                System.out.println(String.format("User: %s %s, starting solving mazes", userInfo.getName(), userInfo.getSurname()));
                for (final Mazes maze : mazes) {
                    final AtomicInteger solvedPathLength = new AtomicInteger(0);
                    try {
                        executionTime[0] = System.currentTimeMillis();
                        solvedPathLength.set(mazeSolver.solve(maze));
                        executionTime[0] = System.currentTimeMillis() - executionTime[0];
                    } catch (Throwable e) {
                        System.out.println(String.format("Maze [%s] dimensions [%dx%d] = Failed, method thrown exception", maze.getName(), maze.getWidth(), maze.getHeight()));
                        continue;
                    }
                    if (maze.getMinimalPathLength() == -1 && solvedPathLength.get() != -1) {
                        System.out.println(String.format("Maze [%s] dimensions [%dx%d] = Failed", maze.getName(), maze.getWidth(), maze.getHeight()));
                        continue;
                    }
                    if (solvedPathLength.get() == maze.getMinimalPathLength()) {
                        System.out.println(String.format("Maze [%s] dimensions [%dx%d] = Success, execution time = %d, steps count = %d", maze.getName(), maze.getWidth(), maze.getHeight(), executionTime[0], solvedPathLength.get()));
                    } else {
                        System.out.println(String.format("Maze [%s] dimensions [%dx%d] = Failed, steps count = %d", maze.getName(), maze.getWidth(), maze.getHeight(), solvedPathLength.get()));
                    }
                }
                System.out.println(String.format("User: %s %s, has finished solving mazes. MySingleID: %s", userInfo.getName(), userInfo.getSurname(), userInfo.getMySingleId()));

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

}
