    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package dataloader;

    import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
   // import org.apache.commons.io.FilenameUtils;
    /**
     *
     * @author vinayak
     */
    public class DataLoader {
        static String locatn=constants.LOCATION;  //your location here
      /**
         * @param args the command line arguments
         */

    /**
     *
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, SQLException, InterruptedException {
              //
            final File folder = new File(locatn);
            Loader a=new Loader();
         // insertData(folder);
           // data2 a=new data2();
            jdbcconn jdbc=new jdbcconn(constants.USERNAME,constants.PASSWORD,constants.SID,constants.PORT);
                    jdbc.connectToDB();
                    jdbc.makeStatement();
            //a.getCarWithCarID(72444,"CAR_DATA", jdbc);
             logo bb=new logo(jdbc,a);
           //Data_Disp s=new Data_Disp(a);
         // Search_Frame k= new Search_Frame ();
        // Search_Panel ex=new Search_Panel();
        
      
      /// a.setVisible(true);
       //filterBox ex=new filterBox(jdbc,a);
         //imagesearch ee=new imagesearch(jdbc);
            
        }


        public static void insertData(final File folder) throws ParserConfigurationException, SAXException, IOException, SQLException, InterruptedException {
            int count=0;
            jdbcconn jdbc=new jdbcconn(constants.USERNAME,constants.PASSWORD,constants.SID,constants.PORT);
                    jdbc.connectToDB();
                    jdbc.makeStatement();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //insertData(fileEntry);//recurse through directories
            } else {
                String filname=fileEntry.getName();
                
                if(filname.endsWith(".xml"))
                {
                //System.out.println(filname);    
                    
                   
                data a =new data();
                a.getdata(locatn+"/"+filname);    // for unix filesystem
                 //  a.getdata(locatn+"\\"+filname); //for windows filesystem
              System.out.println(a.makeInsertString("CAR_DATA"));
                a.insertIntoDbms(jdbc, "CAR_DATA");
                
                
             
                count++;
                
                
                
                }
           System.out.println(count); 
                
            }
        }
    }


    }
