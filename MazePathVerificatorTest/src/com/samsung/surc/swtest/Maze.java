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

public interface Maze {
    public int getWidth();
    public int getHeight();
    public boolean isWall(int x, int y);
}
