/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import static project.Frame1.logs;


/**
 *
 * @author ishraq
 */
public class Threading implements Runnable {

    public static String Lock1 = "Hello ";
    public static String Lock2 = "World!";
    
    @Override
    public void run() {
        if(Thread.currentThread().getName() == "Thread A"){
            log(Thread.currentThread().getName() + " didn't enter yet");
            synchronized (Lock1) {
                log(Thread.currentThread().getName() + " holding Lock1");
                try { Thread.sleep(100); } catch (Exception e) {}
                log(Thread.currentThread().getName() + " waiting Lock2");
                synchronized (Lock2) {
                    log(Thread.currentThread().getName() + " holding Lock1 & Lock2");
                }
            }
            log(Thread.currentThread().getName() + " finished");
        } else {
            log(Thread.currentThread().getName() + " didn't enter yet");
            synchronized (Lock2) {
                log(Thread.currentThread().getName() + " holding Lock2");
                try { Thread.sleep(100); } catch (Exception e) {}
                log(Thread.currentThread().getName() + " waiting Lock1");
                synchronized (Lock1) {
                    log(Thread.currentThread().getName() + " holding Lock1 & Lock2");
                }
            }
//            synchronized (Lock1) {
//                log(Thread.currentThread().getName() + " holding Lock1");
//                try { Thread.sleep(100); } catch (Exception e) {}
//                log(Thread.currentThread().getName() + " waiting Lock2");
//                synchronized (Lock2) {
//                    log(Thread.currentThread().getName() + " holding Lock1 & Lock2");
//                }
//            }
            log(Thread.currentThread().getName() + " finished");
        }
    }
    public void log(String s){
        logs.setText(logs.getText() + "\n" + s);
    }
}
