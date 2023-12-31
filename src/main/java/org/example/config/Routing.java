package org.example.config;

import com.google.inject.Inject;
import com.google.inject.Injector;

import java.lang.reflect.ParameterizedType;

public abstract class Routing<T> {
    @Inject
    private Injector injector;

    private Class<T> controller;

    protected Routing() {
    }

    /**
     * In this method we add routes to javalin instance
     */
    public abstract void bindRoutes();


    /**
     * Return the controller class from the IOC Container
     */
    public T getController() {
        return injector.getInstance(getControllerFromGenericType());
    }


    /**
     * Return the controller class referred by the route
     */
    private Class<T> getControllerFromGenericType() {
        if (controller == null) {
            // getClass -> return the child class, like XyzRouting
            // getGenericSuperClass return the parent class, like Routing<Xyz>
            // We cast to parentclass into ParameterizedType
            controller = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return controller;
    }
}