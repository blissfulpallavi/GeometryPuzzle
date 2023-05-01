package com.geometrypuzzleapp;

public class Coordinate {
    int a;
    int b;

    Coordinate(){}

    Coordinate(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o){
        // null check
        if (o == null) {
            return false;
        }
        // this instance check
        if (this == o) {
            return true;
        }
        // instanceof Check and actual value check
        if ((o instanceof Coordinate) && (((Coordinate) o).getA() == this.a) && (((Coordinate)o).getB() == this.b)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (a / 11) + (b / 11);
        return result;
    }
}
