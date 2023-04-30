import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
public class function2{
    public ImageIcon imgResize(String picPath,int wdth,int hgt){
        ImageIcon imgv=new ImageIcon(picPath);
        Image image=imgv.getImage().getScaledInstance(wdth,hgt,Image.SCALE_SMOOTH);
        ImageIcon icon1=new ImageIcon(image);
        return icon1;
    }
    public String imgSearch(JLabel jLabel_img){
        String location="";
        JFileChooser myfile=new JFileChooser();
        myfile.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fileFilter=new FileNameExtensionFilter("*.Images","jpg","png","gif");
        myfile.addChoosableFileFilter(fileFilter);
        int myfilestate=myfile.showSaveDialog(null);
        if(myfilestate==JFileChooser.APPROVE_OPTION){
            File myfilesel=myfile.getSelectedFile();
            location=myfilesel.getAbsolutePath();
            //imagePath=location;
            jLabel_img.setIcon(imgResize(location,jLabel_img.getWidth(),jLabel_img.getHeight()));   
        }
        else if(myfilestate==JFileChooser.CANCEL_OPTION){
                System.out.println(" IMAGE NOT SELECTED ! ");
        }
        return location;
    }
}

