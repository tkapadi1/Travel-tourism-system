/*
 * To slideshow all the Different Hotels using LOOPS and Multi threading.
 */
package ttms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kappa
 */

public class CheckHotels extends JFrame implements Runnable {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JLabel[] label = new JLabel[]{l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};
    JLabel caption;
    Thread th;

    @Override
    public void run() {
        
        String[] text = new String[]{
            "JW Marriott Hotel",
            "Mandarin Oriental Hotel",
            "Four Seasons Hotel",
            "Radisson Hotel",
            "Classio Hotel",
            "The Bay Club Hotel",
            "Breeze Blows Hotel",
            "Quick Stop Hotel",
            "Happy Mornings Motel",
            "Moss View Hotel"
        };
        
        try {
            
            for (int i = 0; i < 10; i++) {
                
                this.label[i].setVisible(true);
                caption.setText(text[i]);
                this.label[i].add(caption);
                Thread.sleep(2800);
                this.label[i].setVisible(false);
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public CheckHotels() {

        setBounds(450, 200, 750, 500);
        setLayout(null);
        
        ImageIcon i1 = null, 
                i2 = null, 
                i3 = null, 
                i4 = null, 
                i5 = null, 
                i6 = null, 
                i7 = null, 
                i8 = null, 
                i9 = null, 
                i10 = null;
        
        ImageIcon[] image = new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};
        
        Image j1 = null, 
            j2 = null, 
            j3 = null, 
            j4 = null, 
            j5 = null, 
            j6 = null, 
            j7 = null, 
            j8 = null, 
            j9 = null, 
            j10 = null;
        
        Image[] scale = new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
        
        ImageIcon i11 = null, 
                i12 = null, 
                i13 = null, 
                i14 = null, 
                i15 = null, 
                i16 = null, 
                i17 = null, 
                i18 = null, 
                i19 = null, 
                i20 = null;
        
        ImageIcon[] imageFinal = new ImageIcon[]{i11,i12,i13,i14,i15,i16,i17,i18,i19,i20};        
    
        caption = new JLabel();
        caption.setBounds(50, 400, 750, 50);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 35));
        add(caption);
        
        
        for (int i = 0; i <= 9; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("ttms/icons/hotel"+(i+1)+".jpg"));
            scale[i] = image[i].getImage().getScaledInstance(750, 500, Image.SCALE_DEFAULT);
            imageFinal[i] = new ImageIcon(scale[i]);
            this.label[i] = new JLabel(imageFinal[i]);
            this.label[i].setBounds(0, 0, 750, 500);
            add(this.label[i]);
        }
        
        th = new Thread(this); 
        th.start();        

    }

    public static void main(String args[]) {
        new CheckHotels().setVisible(true);

    }
    
    
}
