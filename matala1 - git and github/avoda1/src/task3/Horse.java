// ודים קולטניוק
// 315433201
//עילי אפנג׳ר 
// 324087600
package task3;

public class Horse extends Thread{
	private String name;
	private FinishingLine f;
	private int distance;
	
	public Horse(String name, FinishingLine f, int distance) {
		this.name = name;
		this.f = f;
		this.distance = distance;
	}
	
	public void run() {
		System.out.println(name + ":\t " + distance + " meters to finish");
		while(distance > 0) {
			try {
				Thread.sleep(1000);
				distance -= (int)(Math.random()*20) + 1;
				if(distance <= 0) {
					f.arrive(this);
				}else {
					System.out.println(this.name + ":\t " + distance + " meters to finish");
				}
			}catch(InterruptedException e) {System.out.println(e);}
		}
	}
	

	public String getHorseName() {
		return this.name;
	}
}
