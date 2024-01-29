package alishev;

import java.util.Scanner;

/**
 * 2024-01-26
 * Продвинутая Java: Ключевое слово volatile
 * 16 минут
 * https://www.youtube.com/watch?v=CI_rOvL-OTE
 * тема многопоточность
 */
public class Volatile {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); // запуск выполнения

        //добавим возможность остановить выполнение метода MyThread.run
        Scanner scanner = new Scanner(System.in); //чтобы принимать сообщения из консоли нунжно создать объект класса Сканер
        scanner.nextLine(); // эта строка исполнится когда в консоли будет нажата Enter и выполнение перейдет к след строке кода
        myThread.shutdown(); //выполнить метод для остановки
    }
}
class MyThread extends Thread{
    /**
     * прерывание через переменную isRunning
     * иногда такое прерывание может не сработать (это зависит от версии джавы, ос, процессора и тд )
     * по причине некогерентности кэшей, если выполнение происходит в двух ядрах ЦП и по какой-то причине значения переменной записано в кеше
     * одного ядра, а измененной на false в другом потоке будет записано в кеше другого ядра (проблема когерентности кешей (несовпадение кешей)
     * для 100% уверенности есть ключевое слово volatile перед переменной
     * это значит что эта переменная не будет кешироваться для каждого ядра, а будет хранится в общей памяти.
     */
    private volatile boolean isRunning = true;
    public void run() {
        while (isRunning) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);//задержка в 1 сек.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown() {
        this.isRunning = false;
    }
}
