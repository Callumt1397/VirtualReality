package com.virtualreality;

import org.bukkit.plugin.java.JavaPlugin;

public class VirtualReality extends JavaPlugin{
	
	private static VirtualReality vr;
	
	public void onEnable(){
		vr = this;
		
	}
	
	public static VirtualReality getInstance(){
		return vr;
	}
}
