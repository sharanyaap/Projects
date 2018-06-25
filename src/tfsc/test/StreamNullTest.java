package tfsc.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by sharanya.p on 5/30/2018.
 */
public class StreamNullTest {

    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);
        System.out.println(Optional.ofNullable(collection).orElse(Collections.emptySet()).stream().count());
        System.out.println(Optional.ofNullable(collection).orElse(Collections.emptySet()).stream().map(Object::toString).collect(Collectors.joining(",")).toString());
        collection = null;
        System.out.println(Optional.ofNullable(collection).orElse(Collections.emptySet()).stream().count());
        System.out.println(Optional.ofNullable(collection).orElse(Collections.emptySet()).stream().map(Object::toString).collect(Collectors.joining(",")).toString());
    }

}
