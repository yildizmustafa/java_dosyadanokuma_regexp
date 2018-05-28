package pdpodev;
import java.nio.file.*;
/**
*
* @author Mustafa YILDIZ
* mustafa.yildiz9@ogr.sakarya.edu.tr
* @since 11.03.2018
* 
* PDP 01 Nolu Odev
* 
*/public class Pdpodev {
public static String oku(String fileName)throws Exception
  {
    String str = "";
    str = new String(Files.readAllBytes(Paths.get(fileName)));
    return str;
  }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String str = oku("program.java");
    int ilk=str.indexOf("package");
    int son=str.indexOf("*/");
    StringBuilder sb = new StringBuilder(str);
		sb.delete(ilk, son+2);//.....*/ile açıklama satırı bittiği için son+2 
             
            String silinecek = sb.toString();
            String sonstr = silinecek.trim();
               String ayrilmisstr[] = sonstr.split(" ");
             //sınıf bulan for
             //for(int i=0;i<ayrilmisstr.length;i++)
               //  System.out.println(ayrilmisstr[i]);
             
             
               for (int i=0; i<ayrilmisstr.length; i++) {
            if(ayrilmisstr[i].startsWith("public")&&ayrilmisstr[i+1].startsWith("class")) {    
                        System.out.println();
                System.out.println("Sınıf Adı: "+ayrilmisstr[i+2]);
               }
             }
             //alt elemanları bulan for
             System.out.print("Alt Elemanlar: ");
             for (int i=0; i<ayrilmisstr.length; i++) {
            if(ayrilmisstr[i].startsWith("private")) {    
                      
                System.out.println(ayrilmisstr[i+2]+"--"+ayrilmisstr[i+1]);
               }
             }
             //Üye fonksiyon bulan for
             for (int i=0; i<ayrilmisstr.length; i++) {
            if(ayrilmisstr[i].startsWith("public")&&ayrilmisstr[i+1].indexOf("(")==-1&&!ayrilmisstr[i+1].equals("class")) {    
                      System.out.println("****"+ayrilmisstr[i+2]);
                      System.out.println("Donus Turu: "+ayrilmisstr[i+1]);
                      
               }
            
             }
    
    }}
