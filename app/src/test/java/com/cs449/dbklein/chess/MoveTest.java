package com.cs449.dbklein.chess;

import com.cs449.dbklein.chess.gameLogic.Move;

import junit.framework.Assert;

import org.junit.Test;

public class MoveTest {

    @Test
    public void sameMovesEqualTest() {
        Move move1 = new Move(0, 0, 3, 3);
        Move move2 = new Move(0, 0, 3, 3);

        Assert.assertTrue(move1.equals(move2));
    }

    @Test
    public void differentMovesDontEqualTest() {
        Move move1 = new Move(0, 0, 3, 3);
        Move move2 = new Move(0, 0, 3, 2);

        Assert.assertFalse(move1.equals(move2));
    }

    @Test
    public void nullMovesDontEqualTest() {
        Move move1 = new Move(0, 0, 3, 3);
        Move move2 = null;

        Assert.assertFalse(move1.equals(move2));
    }
}
