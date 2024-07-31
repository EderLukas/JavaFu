package ch.ederlukas.lambdas;

import java.util.Collection;

public interface ManipulateCollectionLambda<T, R extends Collection<T>, S extends Collection<T>> {
    S manipulate(R t);
}
