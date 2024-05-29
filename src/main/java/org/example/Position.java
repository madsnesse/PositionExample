package org.example;


import no.uib.ii.algebaric_structures.Group;
import no.uib.ii.annotations.InheritAxioms;

@InheritAxioms
public class Position implements Comparable<Position>, Group<Position> {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.x + this.y, o.x + o.y);
    }

    @Override
    public Position binaryOperation(Position position) {
        return new Position(this.x + position.x, this.y + position.y);
    }

    @Override
    public Position inverse() {
        return new Position(-this.x, -this.y);
    }

    @Override
    public Position identity() {
        return new Position(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() ) return false;

        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
