/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author kimha
 */
public class Project1 {
        
       public static void join(String inputPath,String outputPath) throws IOException{
        //Mở thư mục, tham chiếu directory dữ thư mục
        File directory = new File(inputPath);
        
        File[] files = directory.listFiles();
        //System.out.println(files.length);
        
        //đọc thư mục đầu tiên
        BufferedImage sprite = ImageIO.read(files[0]);
        
        int spriteWidth = sprite.getWidth()*2;
        int spriteHeight = sprite.getHeight()*2;
        System.out.println(spriteWidth);
        System.out.println(spriteHeight);
        
        //xây dựng spritemap(1 map gồm nhiều sprite) bằng buffered (mỗi tấm ảnh là 1 sprite)
        BufferedImage spriteMap = new BufferedImage(spriteWidth, spriteHeight,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = spriteMap.createGraphics();
        
        int x = 0;
        int y = 0;//vị trí bắt đầu của sprite tiếp theo
//        for(File file:files){ 
//        }
        for(int i = 0; i < 2; i++){
            //tải sprite lên
          sprite=ImageIO.read(files[i]);
           //vẽ sprite lên spritemap
           g2d.drawImage(sprite, null, x,0);
           x+=sprite.getWidth();
          }
          for(int j = 2; j < 4; j++){
              //tải sprite lên
          sprite=ImageIO.read(files[j]);
           //vẽ sprite lên spritemap
           g2d.drawImage(sprite, null, y,sprite.getHeight());
           y+=sprite.getWidth();
          }
       //ghi spritemap ra ổ cứng
       ImageIO.write(spriteMap, "png", new File(outputPath));
    }
       
    
    public static void main(String[] args) {
        try{
            Project1.join("C:\\Users\\kimha\\Documents\\NetBeansProjects\\Project 1\\image", "C:\\\\Users\\\\kimha\\\\Desktop\\\\output\\output.png");
        }catch(IOException ex){
            System.err.println(ex);}
    }
    
}
