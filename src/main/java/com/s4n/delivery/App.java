package com.s4n.delivery;

import com.s4n.delivery.thread.DeliveryThread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
		DeliveryThread delivery1 = new DeliveryThread("delivery1");
		new Thread(delivery1).start();

		DeliveryThread delivery2 = new DeliveryThread("delivery2");
		new Thread(delivery2).start();
		
		DeliveryThread delivery3 = new DeliveryThread("delivery3");
		new Thread(delivery3).start();
		
		DeliveryThread delivery4 = new DeliveryThread("delivery4");
		new Thread(delivery4).start();
		
		DeliveryThread delivery5 = new DeliveryThread("delivery5");
		new Thread(delivery5).start();
		
		DeliveryThread delivery6 = new DeliveryThread("delivery6");
		new Thread(delivery6).start();
		
		DeliveryThread delivery7 = new DeliveryThread("delivery7");
		new Thread(delivery7).start();
		
		DeliveryThread delivery8 = new DeliveryThread("delivery8");
		new Thread(delivery8).start();
		
		DeliveryThread delivery9 = new DeliveryThread("delivery9");
		new Thread(delivery9).start();
		
		DeliveryThread delivery10 = new DeliveryThread("delivery10");
		new Thread(delivery10).start();
		
		DeliveryThread delivery11 = new DeliveryThread("delivery11");
		new Thread(delivery11).start();
		
		DeliveryThread delivery12 = new DeliveryThread("delivery12");
		new Thread(delivery12).start();
		
		DeliveryThread delivery13 = new DeliveryThread("delivery13");
		new Thread(delivery13).start();
		
		DeliveryThread delivery14 = new DeliveryThread("delivery14");
		new Thread(delivery14).start();
		
		DeliveryThread delivery15 = new DeliveryThread("delivery15");
		new Thread(delivery15).start();
		
		DeliveryThread delivery16 = new DeliveryThread("delivery16");
		new Thread(delivery16).start();
		
		DeliveryThread delivery17 = new DeliveryThread("delivery17");
		new Thread(delivery17).start();
		
		DeliveryThread delivery18 = new DeliveryThread("delivery18");
		new Thread(delivery18).start();
		
		DeliveryThread delivery19 = new DeliveryThread("delivery19");
		new Thread(delivery19).start();
		
		DeliveryThread delivery20 = new DeliveryThread("delivery20");
		new Thread(delivery20).start();
    }
}
