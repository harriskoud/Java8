package hu.java.eight.future.domain;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public final class Shop {
    private static final long DELAY = 1000L;

    private final String name;

    private static void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Shop(final String shopName) {
        this.name = shopName;
    }

    public Future<Double> getPriceAsync(final String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public double getPrice(final String product) {
        return calculatePrice(product);
    }

    public String getName() {
        return name;
    }

    private double calculatePrice(final String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }
}