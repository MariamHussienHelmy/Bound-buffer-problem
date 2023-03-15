
package com.mycompany.finalfinal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class ProductionLine {
    public int chocolate = 1;
    public int size =(Integer.parseInt(MainFrame2.numPacks.getText()))*2;
    public Queue<Integer> aqueue;
    public ProductionLine() {
        this.aqueue = new LinkedList<>();

    }

    public final Semaphore key = new Semaphore(1);
    public final Semaphore produced = new Semaphore(0);
    public final Semaphore consumed = new Semaphore(size); 

    public void get() throws InterruptedException {
                Thread.currentThread().sleep(2000);

        if (aqueue.size() >= 1) {
        try {
            produced.acquire();
            key.acquire();
                int remove = aqueue.remove();
                MainFrame2.jTextArea1.append("consumer consumed chocolate: " + remove + "\n");
                MainFrame2.jTextArea1.append("Production line size is " + aqueue.size()+ "\n");
                key.release();
            consumed.release();
        } catch (InterruptedException e){
                MainFrame2.jTextArea1.append("Process is interrupted" + "\n");

            }
        }  else {
                MainFrame2.jTextArea1.append("Production line is empty"+"\n");
            }


    }

    public void put() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        if(aqueue.size()<=size){
            try{
                consumed.acquire();
            key.acquire();
            aqueue.add(chocolate);
        MainFrame2.jTextArea1.append("producer produced chocolate: " + chocolate + "\n");
        MainFrame2.jTextArea1.append("Production line size is " + aqueue.size()+"\n");
            chocolate++;
            Thread.sleep(500);
        key.release();
            produced.release();}
catch (InterruptedException e){
                    MainFrame2.jTextArea1.append("Process is interrupted"+ "\n");

                }

        }  else
            MainFrame2.jTextArea1.append("Production line is completed"+ "\n");

    }

}