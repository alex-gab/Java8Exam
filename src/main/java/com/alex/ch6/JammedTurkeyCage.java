package com.alex.ch6;

public final class JammedTurkeyCage implements AutoCloseable {
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
        try (JammedTurkeyCage jammedTurkeyCage = new JammedTurkeyCage()) {
            throw new RuntimeException("turkeys ran off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getMessage());
            }
        }
    }
}
