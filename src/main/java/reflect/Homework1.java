package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(java.lang.String.class.getMethods()).sorted(Comparator.comparing(S -> S.getName())).forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(java.lang.String.class.getMethods()).map(S -> S.getName()).distinct().sorted().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(S -> S.getParameterCount() >= 2 && Arrays.stream(S.getParameterTypes()).allMatch(paramtype -> paramtype == Arrays.stream(S.getParameterTypes()).findFirst().get())).sorted(Comparator.comparing(S -> S.getName())).forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(S -> S.getReturnType()).distinct().sorted(Comparator.comparing(S -> S.getName())).forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(S -> Arrays.stream(S.getParameterTypes()).anyMatch(paramtype -> paramtype == boolean.class)).sorted(Comparator.comparing(S -> S.getName())).forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(S -> Arrays.stream(S.getParameterTypes()).allMatch(paramtype -> paramtype == int.class) && S.getParameterCount() != 0).sorted(Comparator.comparing(S -> S.getName())).forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(S -> S.getName()).max(Comparator.comparingInt(S -> S.length())).get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(S -> S.getModifiers() == java.lang.reflect.Modifier.PUBLIC).map(S -> S.getName()).max(Comparator.comparingInt(S -> S.length())).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(S -> S.getParameterCount()).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(S -> S.getParameterCount()).max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).max(Comparator.comparingInt(S -> S.getParameterCount())).get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
    	Arrays.stream(String.class.getDeclaredMethods()).flatMap(S -> Arrays.stream(S.getParameterTypes())).distinct().sorted(Comparator.comparing(paramtypes -> paramtypes.getName())).forEach(System.out::println);
    }

}
