package com.training.exilant;

import java.util.List;

class Device{
	private int deviceId; 
	private String deviceName;
	
	public Device(int deviceId, String deviceName) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + "]";
	} 
	
}

public class ConvertListToArrayEx {
	public static void main(String[] args) {
		
		List<Device> deviceList = 
				List.of(
						new Device(101, "Laptop"), 
						new Device(102, "Presenter")
				); 
		
		deviceList.forEach(System.out :: println);
//		deviceList.add(new Device(103, "Mouse")); 
		
		Device [] deviceArray = deviceList.toArray(new Device[8]); 
		System.out.println(deviceArray.length);
		for(Device temp : deviceArray) {
			System.out.println(temp);
		}
		
		// we already have toArray as the function then why are we calling 
		// size ???? 
		Device [] deviceArray1  = deviceList.toArray(Device[] :: new); 
		System.out.println("-----------------------------");
		for(Device temp : deviceArray1) {
			System.out.println(temp);
		}
	}
}





















