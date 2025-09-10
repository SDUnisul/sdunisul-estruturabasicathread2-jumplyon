public class Exercicio3 {
    public static void main(String[] args) {
        System.out.println("3: Corrida de Threads");

        class Corredor implements Runnable {
            private String name;

            public Corredor(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                try {
                    for (int i = 10; i <= 100; i += 10) {
                        System.out.println(name + " percorreu " + i + " metros");
                        Thread.sleep(400);
                    }
                } catch (InterruptedException e) {
                    System.out.println(name + " foi interrompido.");
                }
            }
        }
        Thread c1 = new Thread(new Corredor("Corredor 1"));
        Thread c2 = new Thread(new Corredor("Corredor 2"));
        Thread c3 = new Thread(new Corredor("Corredor 3"));
        c1.start();
        c2.start();
        c3.start();
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fim\n");
    }
}
