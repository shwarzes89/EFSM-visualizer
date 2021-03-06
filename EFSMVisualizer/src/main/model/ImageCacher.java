package main.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageCacher {
	
	private static HashMap<String, BufferedImage> imageCache
		= new HashMap<String, BufferedImage>();
	
	public static void load() {
		
		if(imageCache == null) return;
		
		for(File f : getFileList()) {
			
			String filePath = f.getAbsolutePath();
			
			try {
				if(filePath.contains(".png"))
					imageCache.put(extractFileName(filePath), ImageIO.read(new File(filePath)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static File[] getFileList() {
		return new File(System.getProperty("user.dir") + "/img/").listFiles();
	}
	
	private static String extractFileName(String filePath) {
		int lastDelimIdx = filePath.lastIndexOf("\\")+1;
		return filePath.substring(lastDelimIdx);
	}
	
	public static BufferedImage getImage(String fileName) throws Exception {
		if(imageCache == null) throw new Exception();
		return imageCache.get(fileName);
	}
}
