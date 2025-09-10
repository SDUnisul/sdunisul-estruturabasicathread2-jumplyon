public class Exercicio4 {
    public static void main(String[] args) {
        System.out.println("4: Números e Letras");

        class Numeros implements Runnable {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Número: " + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrompida.");
                    }
                }
            }
        }

        class Letras implements Runnable {
            @Override
            public void run() {
                for (char c = 'A'; c <= 'E'; c++) {
                    System.out.println("Letra: " + c);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        System.out.println("Thread de letras interrompida!");
                    }
                }
            }
        }

        Thread t1 = new Thread(new Numeros());
        Thread t2 = new Thread(new Letras());

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
