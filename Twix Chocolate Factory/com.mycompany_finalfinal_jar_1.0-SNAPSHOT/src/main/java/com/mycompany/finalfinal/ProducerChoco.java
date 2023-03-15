
package com.mycompany.finalfinal;

public class ProducerChoco  extends Thread implements Runnable {
    public ProductionLine mybuffer;
    public ProducerChoco(ProductionLine mybuffer){
        this.mybuffer = mybuffer;
    }
    public void run(){
        
            try {
                Thread.currentThread().sleep(750);
                mybuffer.put();

            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
