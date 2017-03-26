package com.alex.ch3;

public final class Container<T> {
    private T cargo;

    public void load(T cargo) {
        this.cargo = cargo;
    }

    public T unload() {
        return cargo;
    }
}
