package com.geometrypuzzleapp;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


/***************************************************************
 * Welcome to GIC geometric puzzle app. You can select from the following 2 options:
 *
 * 1. Create Custom shape - this would require minimum of 3 co-ordinates (all positive values only)
 *          Test: This would be tested against right coordinate to form the shape i.e.:
 *          a. non-repeated co-ordinates
 *          b. once the shape is formed, new co-ordinates cannot be entered against modifying the shape.
 *
 * 2. Generate Random shape - this would require a minimum of 3 co-ordinates and maximum of 8 co-ordinates (all positive values only)
 *          Test: This would be tested against if the co-ordinate (all positive values only) lies inside of the shape or outside of the shape.
 *
 ***************************************************************/
public class SolvePuzzle {
    private static Constants constants = new Constants();
    private static Scanner scanner = null;

    public static void main(String[] args) {
        SolvePuzzle solvePuzzle = new SolvePuzzle();
        System.out.println(constants.GIC_WELCOME);

        scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            solvePuzzle.createCustomShape();
        } else {
            solvePuzzle.generateRandomShape();
        }
    }

    private void createCustomShape() {
        HashSet<Coordinate> coordinateSet = new HashSet<Coordinate>();
        System.out.println("Inside createCustomShape");
        int size = coordinateSet.size();
        Coordinate[] shape = null;
        boolean flag = Boolean.TRUE;
        boolean quit = Boolean.FALSE;

        while (true) {
            try {
                if (size == 0) {
                    System.out.println(MessageFormat.format(Constants.ENTER_COORDINATES, (size + 1)));
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    String[] inputArr = input.split(" ");
                    try {
                        Coordinate coordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
                        if (checkIfDuplicate(coordinate, coordinateSet)) {
                            coordinateSet.add(coordinate);
                            size = coordinateSet.size();
                        }
                    } catch (Exception e) {
                        System.out.println(Constants.INPUT_ERROR);
                        System.out.println(e.getMessage());
                    }

                } else if (size < 3) {
                    System.out.println(Constants.SHAPE_INCOMPLETE);
                    printCoordinates(coordinateSet);
                    System.out.println(MessageFormat.format(Constants.ENTER_COORDINATES, (size + 1)));
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    String[] inputArr = input.split(" ");
                    try {
                        Coordinate coordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
                        if (checkIfDuplicate(coordinate, coordinateSet)) {
                            coordinateSet.add(coordinate);
                            size = coordinateSet.size();
                        }
                    } catch (Exception e) {
                        System.out.println(Constants.INPUT_ERROR);
                        System.out.println(e.getMessage());
                    }
                } else if (flag == Boolean.FALSE) {
                    if (quit == Boolean.TRUE) {
                        System.out.println(Constants.GIC_EXIT);
                        break;
                    } else {
                        quit = testPuzzle(shape, coordinateSet, size);
                    }
                } else {
                    System.out.println(Constants.SHAPE_COMPLETE);
                    printCoordinates(coordinateSet);
                    System.out.println(MessageFormat.format(Constants.FINAL_INPUT_REQUIRED, (size + 1)));
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    String[] inputArr = input.split(" ");
                    try {
                        if (inputArr[0].equalsIgnoreCase("#")) {
                            if (size < 3)
                                System.out.println(Constants.INSUFFICIENT_COORDINATES);
                            else {
                                flag = Boolean.FALSE;
                                quit = testPuzzle(shape, coordinateSet, size);
                            }
                        } else {
                            Coordinate coordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
                            if (checkIfDuplicate(coordinate, coordinateSet)) {
                                coordinateSet.add(coordinate);
                                size = coordinateSet.size();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(Constants.INPUT_ERROR);
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void generateRandomShape() {
        System.out.println("Inside generateRandomShape");
        HashSet<Coordinate> coordinateSet = new HashSet<Coordinate>();
        int size = coordinateSet.size();
        Coordinate[] shape = null;
        boolean flag = Boolean.TRUE;
        boolean quit = Boolean.FALSE;

        while (true) {
            try {
                if (size == 0) {
                    System.out.println(MessageFormat.format(Constants.ENTER_COORDINATES, (size + 1)));
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    String[] inputArr = input.split(" ");
                    try {
                        Coordinate coordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
                        if (checkIfDuplicate(coordinate, coordinateSet)) {
                            coordinateSet.add(coordinate);
                            size = coordinateSet.size();
                        }
                    } catch (Exception e) {
                        System.out.println(Constants.INPUT_ERROR);
                        System.out.println(e.getMessage());
                    }

                } else if (size < 3) {
                    System.out.println(Constants.SHAPE_INCOMPLETE);
                    printCoordinates(coordinateSet);
                    System.out.println(MessageFormat.format(Constants.ENTER_COORDINATES, (size + 1)));
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    String[] inputArr = input.split(" ");
                    try {
                        Coordinate coordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
                        if (checkIfDuplicate(coordinate, coordinateSet)) {
                            coordinateSet.add(coordinate);
                            size = coordinateSet.size();
                        }
                    } catch (Exception e) {
                        System.out.println(Constants.INPUT_ERROR);
                        System.out.println(e.getMessage());
                    }
                } else if (flag == Boolean.FALSE) {
                    if (quit == Boolean.TRUE) {
                        break;
                    } else {
                        quit = testPuzzle(shape, coordinateSet, size);
                    }
                } else {
                    System.out.println(Constants.SHAPE_COMPLETE);
                    printCoordinates(coordinateSet);
                    System.out.println(MessageFormat.format(Constants.FINAL_INPUT_REQUIRED, (size + 1)));
                    scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    String[] inputArr = input.split(" ");
                    try {
                        if (inputArr[0].equalsIgnoreCase("#")) {
                            if (size < 3)
                                System.out.println(Constants.INSUFFICIENT_COORDINATES);
                            else {
                                flag = Boolean.FALSE;
                                quit = testPuzzle(shape, coordinateSet, size);
                            }
                        } else {
                            Coordinate coordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
                            if (checkIfDuplicate(coordinate, coordinateSet)) {
                                if(size<8) {
                                    coordinateSet.add(coordinate);
                                    size = coordinateSet.size();
                                }else{
                                    System.out.println(Constants.INPUT_RESTRICTED);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(Constants.INPUT_ERROR);
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Test the puzzle if the testing coodinate lies inside or outside of the shape
     * @param shape
     * @param coordinateSet
     * @param size
     * @return
     */
    public boolean testPuzzle(Coordinate[] shape, HashSet<Coordinate> coordinateSet, int size) {
        System.out.println("Testing puzzle");
        if (shape == null) {
            shape = new Coordinate[size];
            System.out.println(Constants.SHAPE_IS_FINALISED);
            int i = 0;
            for (Iterator<Coordinate> it = coordinateSet.iterator(); it.hasNext(); ) {
                Coordinate coordinate = it.next();
                System.out.println(i + ":(" + coordinate.a + "," + coordinate.b + ")");
                shape[i] = coordinate;
                i++;
            }
        }
        System.out.println(Constants.TEST_SHAPE_MSG);
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        if (inputArr[0].equalsIgnoreCase("#")) {
            return Boolean.TRUE;
        } else {
            Coordinate findCoordinate = new Coordinate(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
            if (checkIfCoordinateIsInside(shape, size, findCoordinate) == 1)
                System.out.println(MessageFormat.format(Constants.POINT_INSIDE,findCoordinate.a,findCoordinate.b));
            else
                System.out.println(MessageFormat.format(Constants.POINT_OUTSIDE,findCoordinate.a,findCoordinate.b));
        }

        return Boolean.FALSE;

    }

    /**
     * Check if the new coordinate input is a duplicate of an existing one, which is not allowed.
     * All co-ordinates should be unique.
     *
     * @param coordinate
     * @param coordinateSet
     * @return
     */
    private boolean checkIfDuplicate(Coordinate coordinate, HashSet<Coordinate> coordinateSet) {
        if (coordinateSet.contains(coordinate)) {
            System.out.println(MessageFormat.format(Constants.INVALID_INPUT, coordinate.a, coordinate.b));
            System.out.println(Constants.INVALID_INPUT_MSG);
            return false;
        }

        return true;
    }

    /**
     * Print the co-ordinates in the Set so far
     *
     * @param coordinateSet
     */
    private void printCoordinates(HashSet<Coordinate> coordinateSet) {
        int i = 0;
        for (Iterator<Coordinate> it = coordinateSet.iterator(); it.hasNext(); ) {
            Coordinate coordinate = it.next();
            System.out.println(i + ":(" + coordinate.a + "," + coordinate.b + ")");
            i++;
        }
    }

    /**
     * Check if line 1 intersects line 2
     * @param l1
     * @param l2
     * @return
     */
    static int doesIntersect(Line l1, Line l2) {
        // Four direction for two lines and points of other
        // line
        int dir1 = path(l1.c1, l1.c2, l2.c1);
        int dir2 = path(l1.c1, l1.c2, l2.c2);
        int dir3 = path(l2.c1, l2.c2, l1.c1);
        int dir4 = path(l2.c1, l2.c2, l1.c2);

        // When intersecting
        if (dir1 != dir2 && dir3 != dir4)
            return 1;

        // When p2 of line2 are on the line1
        if (dir1 == 0 && onTheLine(l1, l2.c1) == 1)
            return 1;

        // When p1 of line2 are on the line1
        if (dir2 == 0 && onTheLine(l1, l2.c2) == 1)
            return 1;

        // When p2 of line1 are on the line2
        if (dir3 == 0 && onTheLine(l2, l1.c1) == 1)
            return 1;

        // When p1 of line1 are on the line2
        if (dir4 == 0 && onTheLine(l2, l1.c2) == 1)
            return 1;

        return 0;
    }

    static int path(Coordinate c1, Coordinate c2, Coordinate c3) {
        int val = (c2.b - c1.b) * (c3.a - c2.a)
                - (c2.a - c1.a) * (c3.b - c2.b);

        if (val == 0)

            // Collinear
            return 0;

        else if (val < 0)

            // Anti-clockwise direction
            return 2;

        // Clockwise direction
        return 1;
    }

    /**
     * Check if the coodinates lies on the line
     * @param line
     * @param coordinate
     * @return
     */
    static int onTheLine(Line line, Coordinate coordinate) {
        // Check whether coordinate is on the line or not
        if (coordinate.a <= Math.max(line.c1.a, line.c2.a)
                && coordinate.a >= Math.min(line.c1.a, line.c2.a)
                && (coordinate.b <= Math.max(line.c1.b, line.c2.b)
                && coordinate.b >= Math.min(line.c1.b, line.c2.b)))
            return 1;

        return 0;
    }

    /**
     * Check if coordinates lie inside
     * @param shape
     * @param size
     * @param findCoordinate
     * @return
     */
    int checkIfCoordinateIsInside(Coordinate[] shape, int size, Coordinate findCoordinate) {

        // When polygon has less than 3 edge, it is not
        // polygon

        if (size < 3)
            return 0;

        // Create a point at infinity, y is same as point p
        Coordinate infiniteCo = new Coordinate(9999, findCoordinate.b);
        Line exline = new Line(findCoordinate, infiniteCo);
        int count = 0;
        int i = 0;
        do {

            // Forming a line from two consecutive points of
            // poly
            Line side = new Line(shape[i], shape[(i + 1) % size]);
            if (doesIntersect(side, exline) == 1) {

                // If side is intersects exline
                if (path(side.c1, findCoordinate, side.c2) == 0)
                    return onTheLine(side, findCoordinate);
                count++;
            }
            i = (i + 1) % size;
        } while (i != 0);

        // When count is odd
        return count & 1;
    }


}
