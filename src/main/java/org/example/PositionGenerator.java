package org.example;

import no.uib.ii.annotations.DefinedGenerator;
import no.uib.ii.defaultgenerators.Generator;

@DefinedGenerator
public class PositionGenerator extends Generator<Position> {
    private final Position3DGenerator position3DGenerator = new Position3DGenerator();
    @Override
    public Position generate() {
        if (random.nextBoolean()) return position3DGenerator.generate();
        return new Position(random.nextInt(), random.nextInt());
    }
}
