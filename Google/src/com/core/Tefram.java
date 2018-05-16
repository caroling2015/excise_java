package com.core;


import javax.swing.*;

import java.awt.Image;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.concurrent.*;

public class Tefram  {
	   public static boolean GenerateImage(String imgStr)  
	    {   
	        if (imgStr == null)  
	            return false;  
	        Decoder decoder = Base64.getDecoder();
	        try   
	        {  
	            byte[] b = decoder.decode(imgStr);
	            for(int i=0;i<b.length;++i)  
	            {  
	                if(b[i]<0)  
	                {  
	                    b[i]+=256;  
	                }  
	            }  
	            String imgFilePath = "img.png";  
	            OutputStream out = new FileOutputStream(imgFilePath);      
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        }   
	        catch (Exception e)   
	        {  
	            return false;  
	        }  
	    }
	public static void show(String strimg) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel(); 
		String[] b = strimg.split(",");
        GenerateImage(b[1]);
		ImageIcon icon = new ImageIcon("img.png");
		label.setIcon(icon);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,200);
		frame.setVisible(true);	
//		Image image = getToolkit().getI
	}
	
	public static void main(String[] args) {
		
	}

}
