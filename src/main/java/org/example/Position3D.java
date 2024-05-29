package org.example;

import no.uib.ii.annotations.Axiom;
import no.uib.ii.annotations.InheritAxioms;

import static no.uib.ii.StaticMethods.assertEquals;

@InheritAxioms
public class Position3D extends Position {
    private final int z;

    public Position3D(int x, int y) {
        super(x, y);
        this.z = 0;
    }

    public Position3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public Position identity() {
        Position p = new Position(0,0).identity();
        return new Position3D(p.getX(), p.getY(), 0);
    }

    @Override
    public Position3D inverse() {
        Position p = new Position(this.getX(), this.getY()).inverse();
        return new Position3D(p.getX(), p.getY(), -this.z);
    }

    @Override
    public Position binaryOperation(Position p) {
        Position q = super.binaryOperation(p);
        if (p instanceof Position3D) {
            return new Position3D(q.getX(), q.getY(), this.getZ() + ((Position3D) p).getZ());
        }
        return q;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Position3D that = (Position3D) o;
        return z == that.z;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + z;
        return result;
    }

    @Axiom
    public static void binaryOperationWithPositionReturnsPosition(Position3D p) {
        org.example.Position q = new org.example.Position(1,1);
        org.example.Position newP = p.binaryOperation(q);
        assertEquals(org.example.Position.class, newP.getClass());
    }

    public static void main(String[] args) {
        Position3DGenerator generator = new Position3DGenerator();


        Position p = generator.generate();
        Position3D p2 = generator.generate();
        p.equals(p2);
    }
}
