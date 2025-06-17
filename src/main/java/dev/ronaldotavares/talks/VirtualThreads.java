package dev.ronaldotavares.talks;

public class VirtualThreads {
    public static void main(String[] args) {
        System.out.println("Virtual Threads");

        var virtualThreads = new VirtualThreads();
        virtualThreads.creatingThreads();
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