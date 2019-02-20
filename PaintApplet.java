/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pintPk;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

/**
 *
 * @author FATEMA
 */
public class PaintApplet extends Applet {

    String flag;
    Button bline;
    Button brect;
    Button boval;
    Button red;
    Color state;
    Button green;
    Button blue;
   Button Er;
    
  
    // class line
    class myline{
     private int x, y, x2, y2;
     Color linecolor;
        public myline() { }
        
        public myline(int x1, int y1, int x2, int y2) {
            this.x = x1;
            this.y = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    // class rect
    class myrect{
        private int x, y, w, h; 
        Color rectcolor;
       public myrect(){}
       public myrect(int x,int y,int z,int s){
            this.x = x;
            this.y = y;
            this.w = z;
            this.h =s ;
      }
  }
   
    //class oval
    class myoval{
          Color ovalcolor;
        private int x, y, w, h; 
       public myoval(){}
       public myoval(int a,int b,int c,int d){
            this.x = a;
            this.y = b;
            this.w = c;
            this.h =d ;
       } 
    }
    
    //vector line
    Vector<myline> dline=new Vector<>();
    myline line = new myline();
    int x1;
    int y1;
    int x2;
    int y2;
   //vector rect
    Vector<myrect> drect=new Vector<>();
    myrect rect=new myrect();
    int x;
    int y;
    int z;
    int s;
    //vector circle
     Vector<myoval> doval=new Vector<>();
    myoval oval=new myoval();
    int a;
    int b;
    int c;
    int d; 
    
    
    @Override
    public void init() {
        //line
         bline= new Button("line");
        bline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               flag="line";
            }
        });
        add(bline);
        
        //rect
        brect=new Button("rectangile");
         brect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               flag="rect";
            }
        });
        add(brect);
        //oval
        boval=new Button("oval");
        boval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               flag="oval";
            }
        });
       add(boval); 
        //red
       red=new Button("red");
      red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
              state=Color.red;
              repaint();
            }
        });
      add(red);
      //green
      
      green=new Button(" green");
      green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
              state=Color.green;
              repaint();
            }
        });
      add(green);
    //blue
      
      blue=new Button(" blue");
      blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
              state=Color.blue;
              repaint();
            }
        });
      add(blue);
      //erase
      
      Er=new Button(" EraseAll");
     Er.addActionListener(new ActionListener() {
          @Override
           public void actionPerformed(ActionEvent e) 
           {
                
            
              dline.clear();
              doval.clear();
              drect.clear();
              repaint();
            }
        });
     add(Er);
      
      //
        this.addMouseListener(new MouseListener() 
        {
              @Override
             public void mouseClicked(MouseEvent e) { }

             @Override
             public void mousePressed(MouseEvent e) {
                 if(flag.equals("line") || flag.equals("rect") || flag.equals("oval")){
                     if (flag == "line") {
                         line = new myline();
                         x1 = e.getX();
                         y1 = e.getY();
                         line.x = x1;
                         line.y = y1;
                         line.linecolor=state;
                         dline.add(line);
                     }else if (flag == "rect") {
                         rect = new myrect();
                         x = e.getX();
                         y = e.getY();
                         rect.x = x;
                         rect.y = y;
                         rect.rectcolor=state;
                         drect.add(rect);
                    }
                     else if (flag == "oval") {
                         oval = new myoval();
                         a = e.getX();
                         b = e.getY();
                         oval.x = a;
                         oval.y = b;
                         oval.ovalcolor=state;
                         doval.add(oval);
                     }else{
                         System.out.println("flaaaaaag");
                     }
                }        
            }
             @Override
             public void mouseReleased(MouseEvent e) {}

             @Override
             public void mouseEntered(MouseEvent e) {}

             @Override
             public void mouseExited(MouseEvent e) {}       
        });
        this.addMouseMotionListener(new MouseMotionListener() {

             @Override
             public void mouseDragged(MouseEvent e) {
                 if(flag.equals("line") || flag.equals("rect") || flag.equals("oval") ){
                     if (flag.equals("line")) {
                         x2 = e.getX();
                         y2 = e.getY();
                         line.x2 = x2;
                         line.y2 = y2;
                     } else if (flag.equals("rect")) {
                         z = e.getX();
                         s = e.getY();
                         rect.w = z;
                         rect.h = s;
                     }
                     else if (flag.equals("oval")) {
                         c = e.getX();
                         d = e.getY();
                         oval.w = c;
                         oval.h = d;
                     } else {
                         System.out.println("flaaaaaaaag");
                     }
                 }
                    repaint();
           }
             

             @Override
             public void mouseMoved(MouseEvent e) {}});
        
           }
    
    
    @Override
        public void paint(Graphics g) {
            g.drawLine(line.x, line.y, line.x2, line.y2);
            for (int j = 0; j < dline.size(); j++) {
                g.setColor(dline.get(j).linecolor);
                g.drawLine(dline.get(j).x,dline.get(j).y, dline.get(j).x2,dline.get(j).y2);
            }
            g.drawRect(rect.x, rect.y, rect.w, rect.h);
            for (int i = 0; i < drect.size(); i++) {
                g.setColor(drect.get(i).rectcolor);
                g.drawRect(drect.get(i).x,drect.get(i).y, drect.get(i).w,drect.get(i).h);
            }
            g.drawOval(oval.x, oval.y, oval.w, oval.h);
            for (int p = 0; p < doval.size(); p++) {
                g.setColor(doval.get(p).ovalcolor);
                 g.drawOval(doval.get(p).x,doval.get(p).y, doval.get(p).w,doval.get(p).h);
            }            
        }               
 }

