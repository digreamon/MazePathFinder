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

package com.samsung.surc.swtest;

public enum Mazes implements Maze {
    M1(new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 1, 1},
            {0, 1, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0}
    }, 10, "Maze 1"),

    M2(new int[][]{
            {0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 1, 1, 0, 0},
            {1, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0}
    }, 10, "Maze 2"),

    M3(new int[][]{
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 0, 0}
    }, 12, "Maze 3"),

    M4(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0}
    }, 27, "Maze 4"),

    M5(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
    }, 12, "Maze 5"),

    M6(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 0, 1},
            {1, 1, 1, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
    }, 13, "Maze 6"),

    M7(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 0, 1},
            {1, 1, 1, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
    }, 21, "Maze 7"),

    M8(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
    }, 22, "Maze 8"),

    M9(new int[][]{
            {0, 1, 1, 0, 0, 0, 1, 1},
            {0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 0, 0}
    }, -1, "Maze with no way 1"),

    M10(new int[][]{
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
    }, -1, "Maze with no way 2"),

    M11(new int[][]{
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
    }, -1, "Maze with no way 3");

    private final int[][] mazeMatrix;
    private final int pathLength;
    private final String name;

    private Mazes(final int[][] mazeMatrix, int pathLength, String name) {
        for (int i = 0; i < mazeMatrix.length; i++) {
            if (mazeMatrix[i].length != mazeMatrix.length) {
                throw new IllegalArgumentException("Matrix width and height must be equal");
            }
        }
        this.mazeMatrix = mazeMatrix;
        this.pathLength = pathLength;
        this.name = name;
    }

    @Override
    public int getWidth() {
        return mazeMatrix[0].length;
    }

    @Override
    public int getHeight() {
        return mazeMatrix.length;
    }

    @Override
    public boolean isWall(int x, int y) {
        return mazeMatrix[y][x] == 1;
    }

    public int getMinimalPathLength() {
        return this.pathLength;
    }

    public String getName() {
        return name;
    }
}
