import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;

public class Main {
    static volatile double gold = 0;
    static volatile double goldPerSecond = 1;
    static volatile boolean running = true;

    static StringBuilder keyBuffer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {

            terminal.enterRawMode();
            NonBlockingReader reader = terminal.reader();

            // Logic Thread
            new Thread(() -> {
                while (running) {
                    gold += goldPerSecond / 10.0;
                    try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                }
            }).start();

            // Input Thread
            new Thread(() -> {
                try {
                    while (running) {
                        int ch = reader.read();

                        if (ch != -1) {
                            synchronized (keyBuffer) {
                                keyBuffer.append((char) ch);
                            }
                        }
                    }
                } catch (IOException e) {
                    running = false;
                }
            }).start();

            // Main Loop
            while (running) {

                handleInput();
                renderUI();

                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        }
    }

    static void renderUI() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("=== THE JAVA FORGE ===");
        System.out.printf("[ Currency: %.1f Gold ]\n", gold);
        System.out.println("[ Income: " + goldPerSecond + " gold/sec ]");
        System.out.println("-----------------------");
        System.out.println(" (S) Buy Upgrade (Cost: 10) | (Q) Quit");

        synchronized (keyBuffer) {
            System.out.println("\nBuffer: " + keyBuffer.toString());
        }

        System.out.print("\nInput > ");
    }

    static void handleInput() {

        synchronized (keyBuffer) {

            while (keyBuffer.length() > 0) {

                char c = Character.toLowerCase(keyBuffer.charAt(0));

                switch (c) {

                    case 's':
                        if (gold >= 10) {
                            gold -= 10;
                            goldPerSecond += 2;
                        }
                        break;

                    case 'q':
                        running = false;
                        System.out.println("\nExiting...");
                        System.exit(0);
                        break;
                }

            }
        }
    }
}