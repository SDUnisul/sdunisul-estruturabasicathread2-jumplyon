public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("1: Thread de contagem");

        class Contador extends Thread {
            private String name;

            public Contador(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(name + ": " + i);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    System.out.println(name + " foi interrompida");
                }
            }
        }

        Thread t1 = new Contador("Thread 1");
        Thread t2 = new Contador("Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fim\n");
    }
}
