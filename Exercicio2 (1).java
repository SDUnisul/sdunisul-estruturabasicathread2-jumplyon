public class Exercicio2 {
    public static void main(String[] args) {
        System.out.println("2: Runnable de mensagem personalizada");

        class MensagemRunnable implements Runnable {
            private String message;

            public MensagemRunnable(String message) {
                this.message = message;
            }

            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(message + " - " + i);
                        Thread.sleep(700);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread interrompida" + message);
                }
            }
        }
        Thread t1 = new Thread(new MensagemRunnable("Olá do Runnable 1: "));
        Thread t2 = new Thread(new MensagemRunnable("Olá do Runnable 2: "));
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
