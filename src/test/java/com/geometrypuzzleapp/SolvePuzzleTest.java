package com.geometrypuzzleapp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SolvePuzzleTest {
    SolvePuzzle solvePuzzle = new SolvePuzzle();

    @Test
    void testPuzzle_pointInside() {
        String input = "3 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Coordinate[] shape = null;
        HashSet<Coordinate> coordinateSet = new HashSet<>();
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,1);
        Coordinate c3 = new Coordinate(5,5);
        coordinateSet.add(c1);
        coordinateSet.add(c2);
        coordinateSet.add(c3);

        int size = coordinateSet.size();
        assertEquals(false, solvePuzzle.testPuzzle(shape,coordinateSet,size));
    }

    @Test
    void testPuzzle_quitGame() {
        String input = "#";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Coordinate[] shape = new Coordinate[3];
        HashSet<Coordinate> coordinateSet = new HashSet<>();
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,1);
        Coordinate c3 = new Coordinate(5,5);
        coordinateSet.add(c1);
        coordinateSet.add(c2);
        coordinateSet.add(c3);

        int size = coordinateSet.size();
        assertEquals(true, solvePuzzle.testPuzzle(shape,coordinateSet,size));
    }

    @Test
    void doesIntersect() {
        Coordinate c1 = new Coordinate(1,2);
        Coordinate c2 = new Coordinate(5,1);
        Line line1 = new Line(c1,c2);
        Coordinate c3 = new Coordinate(3,2);
        Coordinate c4 = new Coordinate(5,5);
        Line line2 = new Line(c3,c4);
        assertEquals(0, solvePuzzle.doesIntersect(line1, line2));
    }

    @Test
    void path() {
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,1);
        Coordinate c3 = new Coordinate(5,5);

        assertEquals(2, solvePuzzle.path(c1, c2, c3));
    }

    @Test
    void coordinatesOnTheLine() {
        Coordinate c1 = new Coordinate(2,1);
        Coordinate c2 = new Coordinate(9999,1);
        Line line = new Line(c1,c2);

        Coordinate inputCoordinate = new Coordinate(400,1);

        assertEquals(1, solvePuzzle.onTheLine(line, inputCoordinate));
    }

    @Test
    void coordinatesOnTheLine2() {
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,5);
        Line line = new Line(c1,c2);

        Coordinate inputCoordinate = new Coordinate(1,1);

        assertEquals(1, solvePuzzle.onTheLine(line, inputCoordinate));
    }

    @Test
    void coordinatesNotOnTheLine() {
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,5);
        Line line = new Line(c1,c2);

        Coordinate inputCoordinate = new Coordinate(7,8);

        assertEquals(0, solvePuzzle.onTheLine(line, inputCoordinate));
    }

    @Test
    void checkIfCoordinateIsInside_pointIsInside() {
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,1);
        Coordinate c3 = new Coordinate(5,5);
        Coordinate[] shape = {c1,c2,c3};

        int size = shape.length;

        Coordinate findCoordinate = new Coordinate(3,2);

        assertEquals(1, solvePuzzle.checkIfCoordinateIsInside(shape, size, findCoordinate));
    }

    @Test
    void checkIfCoordinateIsInside_pointIsOutside() {
        Coordinate c1 = new Coordinate(1,1);
        Coordinate c2 = new Coordinate(5,1);
        Coordinate c3 = new Coordinate(5,5);
        Coordinate[] shape = {c1,c2,c3};

        int size = shape.length;

        Coordinate findCoordinate = new Coordinate(7,8);

        assertEquals(0, solvePuzzle.checkIfCoordinateIsInside(shape, size, findCoordinate));
    }
}