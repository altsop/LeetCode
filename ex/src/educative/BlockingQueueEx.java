package educative;

class BlockingQueueEx {

    public static void main(String[] args) throws InterruptedException {
        final var blockingQueue = new BlockingQueue<Integer>(5);

        final var t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    blockingQueue.enqueue(i);
                    System.out.println("Enqueue %d".formatted(i));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        final var t2 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    final var dequeued = blockingQueue.dequeue();
                    System.out.println("Dequeued %d".formatted(dequeued));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        final var t3 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                try {
                    final var dequeued = blockingQueue.dequeue();
                    System.out.println("Dequeued %d".formatted(dequeued));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        Thread.sleep(500);

        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }

    static class BlockingQueue<T> {

        private final T[] array;
        private final int capacity;
        private int size = 0;

        private int head = 0;
        private int tail = 0;

        private final Object lock = new Object();

        public BlockingQueue(int capacity) {
            array = (T[]) new Object[capacity];
            this.capacity = capacity;
        }

        public void enqueue(T item) throws InterruptedException {
            synchronized (lock) {
                while (size == capacity) lock.wait();

                if (tail == capacity) {
                    tail = 0;
                }

                array[tail] = item;
                tail++;
                size++;

                lock.notifyAll();
            }
        }

        public T dequeue() throws InterruptedException {
            T item;

            synchronized (lock) {
                while (size == 0) lock.wait();

                if (head == capacity) {
                    head = 0;
                }

                item = array[head];
                head++;
                size--;

                lock.notifyAll();
            }

            return item;
        }

    }

}
