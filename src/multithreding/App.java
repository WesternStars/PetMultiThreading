package multithreding;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class App {
    public static void main(String[] args) {
        List<Runnable> tasks = Stream.of(1, 2, 3).map(integer -> new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + integer);
            }
        }).collect(toList());
        MultiExecutor multiExecutor = new MultiExecutor(tasks);
        multiExecutor.executeAll();
    }
}
