package com.virtualreality;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
	private final Plugin PLUGIN;
	private final String FILENAME;
	private final File FOLDER;
	private FileConfiguration config;
	private File configFile;

	public Config(String filename, Plugin instance) {
		if (!filename.endsWith(".yml")) {
			filename = String.valueOf(filename) + ".yml";
		}
		this.FILENAME = filename;
		this.PLUGIN = instance;
		this.FOLDER = this.PLUGIN.getDataFolder();
		this.config = null;
		this.configFile = null;
		this.reload();
	}

	public Config(File folder, String filename, Plugin instance) {
		if (!filename.endsWith(".yml")) {
			filename = String.valueOf(filename) + ".yml";
		}
		this.FILENAME = filename;
		this.PLUGIN = instance;
		this.FOLDER = new File(this.PLUGIN.getDataFolder() + File.separator + folder);
		this.config = null;
		this.configFile = null;
		this.reload();
	}

	public FileConfiguration getConfig() {
		if (this.config == null) {
			this.reload();
		}
		return this.config;
	}

	public void reload() {
		if (!this.FOLDER.exists()) {
			try {
				if (this.FOLDER.mkdir()) {
				}
			} catch (Exception var1_1) {
			}
		}
		this.configFile = new File(this.FOLDER, this.FILENAME);
		if (!this.configFile.exists()) {
			try {
				this.configFile.createNewFile();
			} catch (IOException var1_2) {
			}
		}
		this.config = YamlConfiguration.loadConfiguration((File) this.configFile);
	}

	public void saveDefaultConfig() {
		if (this.configFile == null) {
			this.configFile = new File(this.PLUGIN.getDataFolder(), this.FILENAME);
		}
		if (!this.configFile.exists()) {
			this.PLUGIN.saveResource(this.FILENAME, false);
		}
	}

	public void save() {
		if (this.config == null || this.configFile == null) {
			return;
		}
		try {
			this.getConfig().save(this.configFile);
		} catch (IOException var1_1) {
		}
	}

	public File getFile() {
		return this.configFile;
	}

	public void set(String path, Object o) {
		this.getConfig().set(path, o);
	}
}
