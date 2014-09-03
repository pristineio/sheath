package io.pristine.sheath;

import dagger.ObjectGraph;

/**
 * Simple static wrapper of interaction with the dagger object graph
 */
public class Sheath {
    private static ObjectGraph objectGraph;

    /**
     * Get ready to wield your dagger with your modules you would normally pass to object graph creation
     *
     * @param clientModules
     */
    public static void holster(Object ... clientModules) {
        if (clientModules == null) {
            throw new RuntimeException("Must provide modules to Sheath");
        }

        // Go ahead and create the object graph with the client modules
        objectGraph = ObjectGraph.create(clientModules);
    }

    /**
     * Add any additional modules to your existing object graph
     *
     * @param modules
     */
    public static void plus(Object ... modules) {
        if (objectGraph != null) {
            objectGraph.plus(modules);
        } else {
            throw new RuntimeException("Object graph not set. Please call Sheath.holster");
        }
    }

    /**
     * Inject an object into your object graph
     *
     * @param o
     */
    public static void inject(Object o) {
        if (objectGraph != null) {
            objectGraph.inject(o);
        } else {
            throw new RuntimeException("Object graph not set. Please call Sheath.holster");
        }
    }

    /**
     * Execute any static injections
     */
    public static void injectStatics() {
        if (objectGraph != null) {
            objectGraph.injectStatics();
        } else {
            throw new RuntimeException("Object graph not set. Please call Sheath.holster");
        }
    }

    /**
     * Validate your object graph
     */
    public static void validate() {
        if (objectGraph != null) {
            objectGraph.validate();
        } else {
            throw new RuntimeException("Object graph not set. Please call Sheath.holster");
        }
    }

    /**
     * Get your object
     *
     * @param t
     * @return
     */
    public static Object get(Class t) {
        if (objectGraph != null) {
            return objectGraph.get(t);
        } else {
            throw new RuntimeException("Object graph not set. Please call Sheath.holster");
        }
    }
}
