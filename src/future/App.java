package future;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, Future<Integer>> tasks;
        ExecutorService service = Executors.newCachedThreadPool();
        tasks = new HashMap<>();
        for (int i = 10; i < 20; i++) {
            tasks.put(i, service.submit(new Fibonacci(i)));
        }

        service.shutdown();

        for (Map.Entry<Integer, Future<Integer>> entry : tasks.entrySet()) {
            Future<Integer> task = entry.getValue();
            int index = entry.getKey();
            int result = 0;
            // проверяем завершено ли задание
            if (task.isDone()) {
                // получаем результат вычислений
                result = task.get();
            } else {
                try {
                    // ожидаем результат вычислений еще 100 миллисекунд
                    result = task.get(2000, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    // прерываем выполнение задания
                    task.cancel(true);
                    System.out.println("Вычисление " + index + "-го числа Фибоначчи не уложилось в отведенное время.");
                }
            }
            if (result > 0) {
                System.out.println(index + "-е число Фибоначчи: " + result);
            }
        }
    }
}
