package annotations.no.uib.ii.jaxioms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import no.uib.ii.defaultgenerators.Generator;
import org.example.Position3D;
import org.example.Position3DGenerator;

public class Position3DGeneratedTest {

    @ParameterizedTest()
    @DisplayName(value = "binaryOperationWithPositionReturnsPosition < {0} >")
    @MethodSource("factorybinaryOperationWithPositionReturnsPosition")
    public void binaryOperationWithPositionReturnsPosition(org.example.Position3D p) {
        org.example.Position q = new org.example.Position(1, 1);
        org.example.Position newP = p.binaryOperation(q);
        assertEquals(org.example.Position.class, newP.getClass());
    }

    public static Stream<Arguments> factorybinaryOperationWithPositionReturnsPosition() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "compareToConsistentWithSignum < {0},{1} >")
    @MethodSource("factorycompareToConsistentWithSignum")
    public void compareToConsistentWithSignum(org.example.Position x, org.example.Position y) {
        assertEquals(java.lang.Integer.signum(x.compareTo(y)), -java.lang.Integer.signum(y.compareTo(x)));
    }

    public static Stream<Arguments> factorycompareToConsistentWithSignum() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate()), Named.of("Argument 2:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "associativeBinaryOperation < {0},{1},{2} >")
    @MethodSource("factoryassociativeBinaryOperation")
    void associativeBinaryOperation(org.example.Position a, org.example.Position b, org.example.Position c) {
        org.example.Position ab = a.binaryOperation(b);
        org.example.Position bc = b.binaryOperation(c);
        assertEquals(ab.binaryOperation(c), bc.binaryOperation(a));
    }

    public static Stream<Arguments> factoryassociativeBinaryOperation() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate()), Named.of("Argument 2:", clazzGenerator.generate()), Named.of("Argument 3:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "neutralAxiom < {0} >")
    @MethodSource("factoryneutralAxiom")
    void neutralAxiom(org.example.Position a) {
        assertEquals(a, a.binaryOperation(a.identity()));
    }

    public static Stream<Arguments> factoryneutralAxiom() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "inverseAxiom < {0} >")
    @MethodSource("factoryinverseAxiom")
    void inverseAxiom(org.example.Position a) {
        assertEquals(a.identity(), a.binaryOperation(a.inverse()));
    }

    public static Stream<Arguments> factoryinverseAxiom() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "equalsIsReflexive < {0} >")
    @MethodSource("factoryequalsIsReflexive")
    public void equalsIsReflexive(org.example.Position o) {
        assertEquals(o, o);
    }

    public static Stream<Arguments> factoryequalsIsReflexive() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "equalsIsSymmetric < {0},{1} >")
    @MethodSource("factoryequalsIsSymmetric")
    public void equalsIsSymmetric(org.example.Position x, org.example.Position y) {
        assertEquals(x.equals(y), y.equals(x));
    }

    public static Stream<Arguments> factoryequalsIsSymmetric() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate()), Named.of("Argument 2:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "equalsIsTransitive < {0},{1},{2} >")
    @MethodSource("factoryequalsIsTransitive")
    public void equalsIsTransitive(org.example.Position x, org.example.Position y, org.example.Position z) {
        if (x.equals(y) && y.equals(z)) {
            assertEquals(x, z);
        }
    }

    public static Stream<Arguments> factoryequalsIsTransitive() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate()), Named.of("Argument 2:", clazzGenerator.generate()), Named.of("Argument 3:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "equalsIsConsistent < {0},{1} >")
    @MethodSource("factoryequalsIsConsistent")
    public void equalsIsConsistent(org.example.Position x, org.example.Position y) {
        assertEquals(x.equals(y), x.equals(y));
    }

    public static Stream<Arguments> factoryequalsIsConsistent() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate()), Named.of("Argument 2:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "equalsNullIsFalse < {0} >")
    @MethodSource("factoryequalsNullIsFalse")
    public void equalsNullIsFalse(org.example.Position x) {
        assertEquals(x.equals(null), false);
    }

    public static Stream<Arguments> factoryequalsNullIsFalse() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }

    @ParameterizedTest()
    @DisplayName(value = "equalsCongruence < {0} >")
    @MethodSource("factoryequalsCongruence")
    public void equalsCongruence(org.example.Position o) {
        //the public methods of a class
        var m = o.getClass().getMethods();
        // legg inn metoder som skal sjekkes i axiom prosseseringen
    }

    public static Stream<Arguments> factoryequalsCongruence() {
        Generator<Position3D> clazzGenerator = new Position3DGenerator();
        List<Arguments> clazzStream = new ArrayList();
        for (int i = 0; i < 100; i++) {
            clazzStream.add(Arguments.of(Named.of("Argument 1:", clazzGenerator.generate())));
        }
        return clazzStream.stream();
    }
}
