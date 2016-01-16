package json;

import com.google.gson.stream.JsonWriter;
import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JsonParser {
    
    private JsonWriter writer;

    public JsonParser(FileWriter fw) {
        writer = new JsonWriter(fw);
    }
    
    public void write(Component[] components) throws IOException{
	writer.beginArray();
        for (Component component : components) {
            JLabel label = (JLabel) component;
            writer.beginObject(); 
            writer.name("name").value(label.getName()); 
            
            ImageIcon icon = (ImageIcon)label.getIcon();
            
            writer.name("path").value(icon.getDescription());
            writer.name("positionX").value(label.getX());
            writer.name("positionY").value(label.getY());
            writer.endObject(); 
         }
	writer.endArray();
	writer.close();
        
    }
    
    
}
