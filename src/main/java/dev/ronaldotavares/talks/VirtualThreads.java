package dev.ronaldotavares.talks;

import java.util.concurrent.*;

public class VirtualThreads {
    public static void main(String[] args) {
        System.out.println("Virtual Threads");

        var virtualThreads = new VirtualThreads();
        virtualThreads.creatingThreads();
        virtualThreads.executorService();
    }

    void creatingThreads(){
        System.out.println("Creating Threads");

        Thread.ofPlatform().start(() -> System.out.println("** Hello"));
        System.out.println("** World");

        simpleExample();
        complexExample();
    }

    void simpleExample() {
        System.out.println("Simple Example Virtual Thread");
        Thread t = Thread.ofVirtual().unstarted(() -> {
            System.out.println("Hello from a virtual thread!");
        });
        // Do some other stuff
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    void complexExample() {
        System.out.println("Complex example mixing platform and virtual threads");
        try {
            ComplexExample.main(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void executorService(){
        System.out.println("Executor Service examples");

        singleThreadExecutor();
        futureWithTimedResultCheck();
    }

    void singleThreadExecutor() {
        System.out.println("Single Thread Executor");
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record:" + i);
        };

        try (ExecutorService service =
                     Executors.newSingleThreadExecutor()) {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
        }
    }

    void futureWithTimedResultCheck(){
        System.out.println("Future with Timed Result Check");
        try {
            CheckResults.main(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


class ComplexExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++)
                System.out.println("Printing record:" + i);
        };
        System.out.println("begin");
        var platformThread = Thread.ofPlatform()
                .priority(10)
                .start(printInventory);
        var virtualThread = Thread.ofVirtual()
                .start(printRecords);
        var constructorThread = new Thread(printInventory);
        constructorThread.start();
        System.out.println("end");
        platformThread.join();
        virtualThread.join();
        constructorThread.join();

        //does not create a new thread, runs in the current thread
        new Thread(printInventory).run();
    }
}

class CheckResults {
    private static int counter = 0;
    public static void main(String[] unused) throws Exception {
        try (var service = Executors.newSingleThreadExecutor()) {
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) counter++;
            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        }
    }
}