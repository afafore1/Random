package Cool;

public class ThreadA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadB b = new ThreadB();
		b.start();
		synchronized(b){
			try{
				System.out.println("Waiting for b to complete...");
				b.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("Total is: "+b.total);
			System.out.println("Time taken is "+b.t +" ms");
		}

	}
}
	
	class ThreadB extends Thread{
		int total; 
		long t;
		@Override
		public void run(){
			synchronized(this){
				long s = System.currentTimeMillis();
				int a = 0;
				int b = 1;
				int c;
				for(int i = 0; i <= 10; i++){
					total = a + b;
					a = b;
					b = total;
					//total+=i;
				}
				long end = System.currentTimeMillis();
				t = end - s;
				notify();
			}
		}
	}
