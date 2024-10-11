package complitableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> fs = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            return 42;
        });
        CompletableFuture<Void> fs1 = CompletableFuture.runAsync(() -> System.out.println("runAsync"));

        System.out.println("Test");

//        fs.thenAccept(integer -> System.out.println("thenAccept"));
        System.out.println(fs1.get());
    }

}
