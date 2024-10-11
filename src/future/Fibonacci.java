package future;

import java.util.concurrent.*;

public class Fibonacci implements Callable<Integer> {

    private final int index;

    public Fibonacci(int index) {
        this.index = index;
    }

    @Override
    public Integer call() {
        int first = 0;
        int second = 1;
        if (index == 1) {
            return first;
        } else if (index == 2) {
            return second;
        } else {
            if (index == 18) {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < index - 2; i++) {
                int temp = second;
                second += first;
                first = temp;
            }
            return second;
        }
    }
}