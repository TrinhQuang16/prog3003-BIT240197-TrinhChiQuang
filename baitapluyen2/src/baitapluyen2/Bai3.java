package baitapluyen2;

import java.util.concurrent.CompletableFuture;

public class Bai3 {
    public static void main(String[] args) {
        CompletableFuture<String> authTask = CompletableFuture.supplyAsync(() -> {
            simulateDelay(2000);
            System.out.println("1. Đã xác thực thông tin khách hàng.");
            return "Khách hàng ALC";
        });

        CompletableFuture<String> ticketTask = CompletableFuture.supplyAsync(() -> {
            simulateDelay(3000);
            System.out.println("2. Đã xuất vé xem phim.");
            return "Vé ghế Vip phim cô Dâu 8 tuổi";
        });
        
        CompletableFuture<Void> finalSystem = authTask.thenCombine(ticketTask, (user, ticket) -> {
            return "Hoàn tất đặt vé cho: " + user + " với loại: " + ticket;
        }).thenAccept(result -> {
            System.out.println("Hệ thống báo cáo: " + result);
        });

        finalSystem.join();
        System.out.println("Tất cả tác vụ đã xong.");
    }

    private static void simulateDelay(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) {}
    }
}