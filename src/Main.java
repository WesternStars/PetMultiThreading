import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public List<Integer> list1 = new ArrayList<>();
    public List<Integer> list2 = new ArrayList<>();

    private void operationOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private void operationTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    private void runOperation() {
        for (int i = 0; i < 1000; i++) {
            operationOne();
            operationTwo();
        }
    }

    public void main() throws InterruptedException {
        System.out.println("Starting ....");

        Long start = System.currentTimeMillis();

        Thread t1 = new Thread(this::runOperation);
        Thread t2 = new Thread(this::runOperation);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Long end = System.currentTimeMillis();

        System.out.println("Time duration: " + (end - start));
        System.out.println("List1 size: " + list1.size() + " List2 size: " + list2.size());
    }
}