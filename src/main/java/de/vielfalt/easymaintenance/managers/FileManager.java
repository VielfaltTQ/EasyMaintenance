package de.vielfalt.easymaintenance.managers;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FileManager {

    private File file;
    private YamlConfiguration yamlConfiguration;

    public FileManager(String filePath) {

        this.file = new File(filePath);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);

        if(!this.file.exists()) {

            try {

                this.file.createNewFile();

            } catch(IOException exception) {}

        }

    }

    public void addDefault(String path, Object object) {

        this.yamlConfiguration.options().copyDefaults(true);
        this.yamlConfiguration.addDefault(path, object);
        save();

    }

    public void set(String path, Object object) {

        this.yamlConfiguration.set(path, object);
        save();

    }

    public Object get(String path) { return this.yamlConfiguration.get(path); }
    public Boolean getBoolean(String path) { return this.yamlConfiguration.getBoolean(path); }
    public String getString(String path) { return this.yamlConfiguration.getString(path); }
    public Integer getInteger(String path) { return this.yamlConfiguration.getInt(path); }
    public Double getDouble(String path) { return this.yamlConfiguration.getDouble(path); }
    public Float getFloat(String path) { return Float.valueOf(this.yamlConfiguration.getString(path)); }
    public Short getShort(String path) { return Short.valueOf(this.yamlConfiguration.getString(path)); }
    public Byte getByte(String path) { return Byte.valueOf(this.yamlConfiguration.getString(path)); }
    public Long getLong(String path) { return this.yamlConfiguration.getLong(path); }
    public List<String> getStringList(String path) { return this.yamlConfiguration.getStringList(path); }
    public ConfigurationSection getConfigurationSection(String path) { return this.yamlConfiguration.getConfigurationSection(path); }
    public Set<String> getKeys(Boolean value) { return this.yamlConfiguration.getKeys(value); }

    public void save() {

        try {

            this.yamlConfiguration.save(this.file);

        } catch(IOException exception) {}

    }

}
