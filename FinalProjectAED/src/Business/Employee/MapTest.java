/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author Akshay
 */
public class MapTest {
    
public void maps(String lat, String longi)
{        
JFrame test = new JFrame("Google Maps");
try {
//String latitude = "42.332227";
//String longitude = "-71.099202";
//String imageUrl = "https://www.google.com/maps/@42.3318286,-71.1048009,285m/data=!3m1!1e3";
String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
+ lat
+ ","
+ longi
+ "&zoom=16&size=612x612&scale=2&maptype=hybrid";
String destinationFile = "image.jpg";
// read the map image from Google
// then save it to a local file: image.jpg
//
URL url = new URL(imageUrl);
InputStream is = url.openStream();
OutputStream os = new FileOutputStream(destinationFile);
byte[] b = new byte[2048];
int length;
while ((length = is.read(b)) != -1) {
os.write(b, 0, length);
}
is.close();
os.close();
} catch (IOException e) {
JOptionPane.showMessageDialog(null, "The Lattitude, Longitude value provided is incorrect or there is no internet connectivity to retrieve the image of the location");
}
// create a GUI component that loads the image: image.jpg
//
ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
.getImage().getScaledInstance(630, 600,
java.awt.Image.SCALE_SMOOTH));
test.add(new JLabel(imageIcon));
// show the GUI window
test.setVisible(true);
test.pack();
}
    }
