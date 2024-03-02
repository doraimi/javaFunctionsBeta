package multiThread;
//import multiThread.SubThread;
public class multiThreadTester20240228 {

	public static void main(String[] args) {
		SubThread SubThreadUUU=new SubThread("UUU  ",1,20);
		SubThread SubThreadPPPPP=new SubThread("PPPPP",100,108);
		SubThreadUUU.start();
		SubThreadPPPPP.start();
		
		System.out.println("multiThreadTester20240228 completed");

	}

}
