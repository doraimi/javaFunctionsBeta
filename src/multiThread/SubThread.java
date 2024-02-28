package multiThread;

public class SubThread extends Thread{
	private int startFlg;
	private int endFlg;
	private String myName;
	public SubThread(String name,int startflg,int endflg) {
		this.startFlg=startflg;
		this.endFlg=endflg;
		this.myName=name;
	}
	public void run() {
		int i;
		for (i=this.startFlg;i<this.endFlg;i++) {
			System.out.println("thread name : "+ this.myName+ " |||    NUM: "+i);
		}
	}

}
