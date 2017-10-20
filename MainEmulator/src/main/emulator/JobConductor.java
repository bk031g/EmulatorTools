package main.emulator;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;



import org.apache.xmlrpc.XmlRpcException;

public class JobConductor implements Runnable{
	
	
	//Enabled Flags
	private boolean AtemeTCEnabled;
	private boolean BatonQCEnabled;
	private boolean BatonHCEnabled;
	private boolean ElementalTCEnabled;
	private Timer timer = new Timer();
	
	public AtemeTranscode atemeTC = new AtemeTranscode();
	public BatonFullQC batonQC = new BatonFullQC();
	public BatonFullQC batonHC = new BatonFullQC();
	
	
	
	public void setAtemeTCEnabled(boolean atemeTCEnabled) {
		AtemeTCEnabled = atemeTCEnabled;
	}
	public void setBatonQCEnabled(boolean batonQCEnabled) {
		BatonQCEnabled = batonQCEnabled;
	}
	public void setBatonHCEnabled(boolean batonHCEnabled) {
		BatonHCEnabled = batonHCEnabled;
	}
	public void setElementalTCEnabled(boolean elementalTCEnabled) {
		ElementalTCEnabled = elementalTCEnabled;
	}
	
	
	class delayBatonQC extends TimerTask {
		public void run() {
			atemeTC.fetchXML();
			System.out.println(atemeTC.document.getRootElement().getChildText("state"));
			if (atemeTC.document.getRootElement().getChildText("state").equals("complete")) {
				try {
					batonQC.run();
				} catch (XmlRpcException | IOException e) {
					e.printStackTrace();
				}
				timer.cancel();
			}
		}
	}
	
	
	public void run(){
		
		if(BatonHCEnabled == true){
			try {
				batonHC.run();
			} catch (XmlRpcException | IOException e) {
				e.printStackTrace();
			}
		}
		
		if(AtemeTCEnabled == true && BatonQCEnabled == true){
			atemeTC.run();
			timer.schedule(new delayBatonQC(), 0, 5000);
		}
		else if(BatonQCEnabled == true){
			try {
				batonQC.run();
			} catch (XmlRpcException | IOException e) {
				e.printStackTrace();
			}
		}
		else if(AtemeTCEnabled == true){
			atemeTC.run();
		}
	}
	
}
