
package com.mycompany.finalfinal;


public class ConsumerChoco  extends Thread  implements Runnable{
    private ProductionLine mybuffer;
    public ConsumerChoco(ProductionLine mybuffer){
        this.mybuffer = mybuffer;
    }
    public void run(){
        
            try {
                Thread.currentThread().sleep(2000);
                mybuffer.get();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
}
