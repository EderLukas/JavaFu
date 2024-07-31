package ch.ederlukas.lambdas;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

public class Manipulator<T, R extends Collection<T>, S extends Collection<T>> {
    private final R set;
    private S result;

    public Manipulator(R col) {
        set = col;
    }

    public void manipulate(ManipulateCollectionLambda<T, R, S> m, R c) {
        result = m.manipulate(c);
    }

    public S getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Manipulator{" +
                "set=" + set +
                '}';
    }
}
