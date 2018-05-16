package com.core;

import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;  
import java.util.Base64.Encoder;  
public class Base64Test   
{  
    public static void main(String[] args)  
    {  
        String strImg = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKgAAAAwCAMAAACyoMGoAAAAP1BMVEUAAAAiXmtEgI0UUF1CfosXU2AsaHU3c4BemqdYlKEdWWY"
        		+ "lYW4YVGEDP0wQTFlHg5AUUF2Py9iSztseWmcQTFk/fQrCAAAAAXRSTlMAQObYZgAAAmhJREFUeJzsme3OqyAMx8FkcXPZ9P6v9mTIS6Glt"
        		+ "IBneZL9Py2K7c+2FHDmJ53WbwMIta5/hvTbAEO6fRvAydrWiNtNQLpNwqnKtkElEd22i0l5ThvUNnQ5J5N6cEeC2qFdPhSD+ofLMIrCqtS+"
        		+ "S0k/zguA82EK6oKg7sa8K2S5OwL08/BFiTbIkTHvN0VaTgyKc0LkZAZ83glOB2nRDJkdPmGXqM6k+HgyQ4OOcdszS/1GSrz0IzM6nnbCqNJC"
        		+ "YQraRO/QL5S2EVPehk98qqkJxRptY1vnBCELmH6rxJkvkDTmvQ808wImiL+XVVtl8gFT1oL+VOG8a0lzN7W9ArhU20yAEfBKLe1Kzjz3rh8aN"
        		+ "mJ+HHm/vOrCquSpaQMxPDc8uFuFCMY7K5t5eGVay9+2zfp1BdQeLkkfzdMxeU4D7XQWXE4a/VCdu0yo/01FNLxLVjc6ZtFoa+2COzcKrm+RpAH"
        		+ "cELSxlZEuy5KgSdBUqCQoagbqGmg+cLpYKDZTcBIbd8A5hMmvtKG700GEvZ9ZwyaeJ5hjVtnii2TbYp2RIvVyczH1TZ7ggNEE3UeA2r8VrQ0t"
        		+ "MoqW9QicjWs4RltmTWGQuyDn8RFYfHQJh6jHKktSWQjoQO0MHI9HgMFH7gK0Ususmy6FRRsU5XEc8S4qLQwK71Z8jGNGn4HIrdkHN7b4UQn4F"
        		+ "ZxQ7a/AYDLVNkiNC0GvXkin5ldgm5bw6nYZb1oIvV5jpE0FQO7wH5dWLusXc6YeypbexB3yTz/16PL/JSap438J9tCu+L6ulJ6T+wwi/74u1bP"
        		+ "/0f8a0edzgLRD/wIAAP//EdwGJ9va5iwAAAAASUVORK5CYII="; 
        
        String[] b = strImg.split(",");
        GenerateImage(b[1]);  
    }  
    
    
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
            String imgFilePath = "img1.png";  
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
}  