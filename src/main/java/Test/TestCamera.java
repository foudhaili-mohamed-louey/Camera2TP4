package Test; 
 
import java.util.List; 
import dao.CameraDaolmpl; 
import PhotoShooting.entities.Camera; 
 
public class TestCamera { 
 
 public static void main(String[] args) { 
	 CameraDaolmpl pdao= new CameraDaolmpl(); 
   Camera prod= pdao.save(new Camera("Action","GoPro Hero 10", 23.6F)); 
   System.out.println(prod); 
    
    List<Camera> Cams =pdao.CamerasParMC("ip"); 
    for (Camera p : Cams) 
     System.out.println(p); 
    
  } 
 
} 