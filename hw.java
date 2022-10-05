import java.util.*;
class ticketClass implements Runnable{
	static int total = 10000;
	int tickets;
	static int randnum = 0;
	static Random ran = new Random();
	Thread t;
	ticketClass(String name){
		tickets = 0;
		t = new Thread(this,name);
		t.start();
	}
	
	public void run() {
		while(buyticket())
		{
			for(int i = 0;i<randnum;i++)
			{
				tickets++;
			}
			System.out.println(t.getName()+" buy "+tickets+" tickets");
		}
		System.out.println(t.getName()+" total buy "+tickets+" tickets");
	}
	
	synchronized private static boolean buyticket() {
		if(total>0)
		{
			if(total>4)
				randnum = ran.nextInt(4)+1;
			else
				randnum = ran.nextInt(total)+1;
			
			total-=randnum;	
			
			return true;
		}
		else
			return false;
		
	}
}
public class hw{
	public static void main(String args[])
	{
		ticketClass t1 = new ticketClass("ticket1");
		ticketClass t2 = new ticketClass("ticket2");
		ticketClass t3 = new ticketClass("ticket3");
		ticketClass t4 = new ticketClass("ticket4");

	}
}
