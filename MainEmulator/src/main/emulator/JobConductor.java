package main.emulator;

import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;

public class JobConductor implements Runnable{
	
	private boolean AtemeTCEnabled;
	private boolean BatonQCEnabled;
	private boolean BatonHCEnabled;
	private boolean ElementalTCEnabled;
	
	public AtemeTranscode atemeTC = new AtemeTranscode();
	public BatonFullQC batonQC = new BatonFullQC();
	
	public boolean isAtemeTCEnabled() {
		return AtemeTCEnabled;
	}
	public void setAtemeTCEnabled(boolean atemeTCEnabled) {
		AtemeTCEnabled = atemeTCEnabled;
	}
	public boolean isBatonQCEnabled() {
		return BatonQCEnabled;
	}
	public void setBatonQCEnabled(boolean batonQCEnabled) {
		BatonQCEnabled = batonQCEnabled;
	}
	public boolean isBatonHCEnabled() {
		return BatonHCEnabled;
	}
	public void setBatonHCEnabled(boolean batonHCEnabled) {
		BatonHCEnabled = batonHCEnabled;
	}
	public boolean isElementalTCEnabled() {
		return ElementalTCEnabled;
	}
	public void setElementalTCEnabled(boolean elementalTCEnabled) {
		ElementalTCEnabled = elementalTCEnabled;
	}
	
	
	
	public void run(){
		
		if(AtemeTCEnabled == true){
			atemeTC.run();
		}
		if(BatonQCEnabled == true) {
			try {
				batonQC.run();
			} catch (XmlRpcException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
