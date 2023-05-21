package day11_FakerFile;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));
        // içinde olduğum proejnin dosya yolunu veirir

        System.out.println(System.getProperty("user.home"));
        //C:\Users\RAHMET  bana özel kısmı

        //"C:\Users\RAHMET\Downloads"
        //"C:\Users\RAHMET\Desktop"
// Masaüstünüzdeki text dosyasının varlığını test edin
        //"C:\Users\RAHMET\Desktop\Text.txt"

        // bilgisayarimizda ki varlığını test etmek için dosya yoluna ulşamamız gerek

        //herkes farklı bölüm                              herkes için aynı
        String dosyaYolu =System.getProperty("user.home")+"\\Desktop\\Text.txt";
        System.out.println("dosyaYolu = " + dosyaYolu);


        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\Text.txt";

        String masaDosyaYolu=farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaDosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(masaDosyaYolu)));





    }
}
