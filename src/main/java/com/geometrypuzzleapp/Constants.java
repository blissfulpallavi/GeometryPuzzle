package com.geometrypuzzleapp;

public class Constants {
    public static final String GIC_WELCOME="Welcome to the GIC geometry puzzle app \n"+
            "[1] Create a custom shape \n"+
            "[2] Generate a random shape \n";
    public static final String GIC_EXIT = "Thank You for playing the GIC geometry puzzle app\n" +
            "Have a nice day!";

    public static final String INVALID_INPUT = "New coordinates {0},{1} is invalid!!!";
    public static final String INVALID_INPUT_MSG = "Not adding new coordinates to the current shape.\n";
    public static final String POINT_INSIDE = "Coordinates {0},{1} is within your finalized shape";
    public static final String POINT_OUTSIDE = "Sorry, coordinates {0},{1} is outside of your finalized shape";
    public static final String TEST_SHAPE_MSG = "Please key in test coordinates in x y format or enter # to quit the game";
    public static final String SHAPE_IS_FINALISED = "Your finalized shape is";
    public static final String SHAPE_COMPLETE = "Your current shape is valid and is complete";
    public static final String SHAPE_INCOMPLETE = "Your current shape is incomplete";
    public static final String FINAL_INPUT_REQUIRED = "Please enter # to finalize your shape or enter coordinates {0} in x, y format";
    public static final String ENTER_COORDINATES = "Please enter coordinates {0} in x, y format";
    public static final String INSUFFICIENT_COORDINATES = "Please enter atleast 3 coordinates to complete your shape";
    public static final String INPUT_ERROR = "Invalid input format, please re-enter..";
    public static final String INPUT_RESTRICTED = "Create Random shapes cannot accept more than 8 co-ordinates, please press # to continue";
}
