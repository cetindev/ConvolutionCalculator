
package konvul_odev;

import java.util.Scanner;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

public class GirisTab implements ExampleChart<CategoryChart> {
    public  void main() {
        System.out.println("H[n] mi X[n] mi?\n\n\n"
                + "H[n] ise (1)' e Basınız\nX[n] ise (2)'e Basınız... ..\n");
        Scanner scn=new Scanner(System.in);
        int secim=scn.nextInt();
        if (secim==1) {
            System.out.println("İstenilen Değerleri Girdikden Sonra H[n] Grafiğinin Sinyallerini Ekranda Göreceksiniz");
             GirisTabH<CategoryChart>  hGraf = new girisHh();
        CategoryChart girisHg = hGraf.girisH();
        new SwingWrapper<CategoryChart>(girisHg).displayChart();
           System.out.println("****************************");
        System.out.println("Grafik Tablosu Açılmıştır...");
        System.out.println("****************************");
        }
        else if(secim==2){
            System.out.println("İstenilen Değerleri Girdikden Sonra X[n] Grafiğinin Sinyallerini Ekranda Göreceksiniz");
             // Javadaki xChart kütüphanesini kullanarak Ekrana Grafiği yazdırdım.
        GirisTabx<CategoryChart> xGraf = new girisX();
        CategoryChart chart = xGraf.girisXGra();
        new SwingWrapper<CategoryChart>(chart).displayChart();
        System.out.println("****************************");
        System.out.println("Grafik Tablosu Açılmıştır...");
        System.out.println("****************************");
        }
        else{
            System.out.println("Yanlış Tuşlama Yaptınız");
        }
        
    }

    public CategoryChart getChart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoryChart Konvulusyon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    class girisX implements GirisTabx<CategoryChart> {
         public CategoryChart girisXGra() {
         Scanner scn = new Scanner(System.in);
         int x[];// X Grafiğinin Değerleri
        int h[];// Y Grafiğinin Değerleri
        //Burada x grafiği x(yani yatay) nerden başladığına göre işlem yaptığımız için başlangıç değerini kullanıcıdan alırız
        System.out.print("X[n] Grafiğinin başlama noktasını Giriniz : ");
        int xBasla = scn.nextInt();
        //Burada y grafiği x(yani yatay) değerleinin  nerden başladığına göre işlem yaptığımız için başlangıç değerini kullanıcıdan alırız
        System.out.print("H[n] Grafiğinin başlama noktasını Giriniz : ");
        int hBasla = scn.nextInt();
        //Kullanıcıdan kaç tane değer giriceğini sormamızın amaçı dizimiz kaç boyutlu olacağını öğrenmemizdir
        System.out.print("X Grafiğinin Grafik Uzunlukunluğunu Giriniz : ");
        int Xlenght = scn.nextInt();
        System.out.print("H Grafiğinin Grafik Uzunlukunluğunu Giriniz : ");
        int Hlenght = scn.nextInt();
        if (Xlenght >= Hlenght) {
            h = new int[Xlenght];
            x = new int[Xlenght];
        } else {
            h = new int[Hlenght];
            x = new int[Hlenght];
        }
        int diziX[]=new int[Xlenght];
        int diziH[]=new int[Hlenght];
//x grafiğini Y-eksenindeki değerlerini diziX'e atma işlemi yapılıyor
        int diziXx[]=new int[Xlenght];
        for (int i = 0; i < Xlenght; i++) {
            diziX[i]=x[i];
            diziXx[i]=xBasla;
            xBasla++;
        }
       //Grafiklerin başlangıç değerlerinden itibaren X eksenine karşılık Gelen Y değerleri
        System.out.print("Toplamda " + Xlenght + " tane X Grafiğinin Değeri Vardır ve İstenilen İndise Göre Giriniz \n"
                + "(Yani Girdiğiniz Başlangıç Değerinden İtibaren x-eksenine Karşılık Gelen Değerleri Yazınız....)\n");
        for (int i = 0; i < Xlenght; i++) {
            System.out.println(xBasla + " . Değerinin X Grafiğindeki Y-eksenine Karşılık Gelen Sayıyı Giriniz: \n");
            x[i] = scn.nextInt();
            xBasla++;
        }
         CategoryChart chart = new CategoryChartBuilder().width(500).height(600).title("GRAFİK TABLOSU").build();
        //Burada Grafik Penceresinin ekranda gözükmesini ayarlıyoruz
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Stick);
        //X Grafiğinin Giriş Grafiği
        chart.addSeries("X[n]", diziXx, x);
        return chart;



    }
    }
   class girisHh implements GirisTabH<CategoryChart> {
       
    public CategoryChart girisH() {
         Scanner scn = new Scanner(System.in);
         int x[];// X Grafiğinin Değerleri
        int h[];// Y Grafiğinin Değerleri
        //Burada x grafiği x(yani yatay) nerden başladığına göre işlem yaptığımız için başlangıç değerini kullanıcıdan alırız
        System.out.print("X[n] Grafiğinin başlama noktasını Giriniz : ");
        int xBasla = scn.nextInt();
        //Burada y grafiği x(yani yatay) değerleinin  nerden başladığına göre işlem yaptığımız için başlangıç değerini kullanıcıdan alırız
        System.out.print("H[n] Grafiğinin başlama noktasını Giriniz : ");
        int hBasla = scn.nextInt();
        //Kullanıcıdan kaç tane değer giriceğini sormamızın amaçı dizimiz kaç boyutlu olacağını öğrenmemizdir
        System.out.print("X Grafiğinin Grafik Uzunlukunluğunu Giriniz : ");
        int Xlenght = scn.nextInt();
        System.out.print("H Grafiğinin Grafik Uzunlukunluğunu Giriniz : ");
        int Hlenght = scn.nextInt();
        if (Xlenght >= Hlenght) {
            h = new int[Xlenght];
            x = new int[Xlenght];
        } else {
            h = new int[Hlenght];
            x = new int[Hlenght];
        }
        int diziX[]=new int[Xlenght];
        int diziH[]=new int[Hlenght];
//x grafiğini Y-eksenindeki değerlerini diziX'e atma işlemi yapılıyor

        int diziHx[]=new int[Hlenght];
        //diziH'ı Giris tablosu sınıfına attık
        for (int i = 0; i < Hlenght; i++) {
            diziH[i]=h[i];
            diziHx[i]=hBasla;
            hBasla++;
        }
        /*int diziXx[]=new int[Xlenght];
        for (int i = 0; i < Xlenght; i++) {
            diziX[i]=x[i];
            diziXx[i]=xBasla;
            xBasla++;
        }*/

        System.out.print("Toplamda " + Hlenght + " tane X Grafiğinin Değeri Vardır ve İstenilen İndise Göre Giriniz \n"
                + "+ \"(Yani Girdiğiniz Başlangıç Değerinden İtibaren x-eksenine Karşılık Gelen Değerleri Yazınız....)\n");
        for (int i = 0; i < Hlenght; i++) {
            System.out.println(hBasla + " . Değerinin H Grafiğindeki Y-eksenine Karşılık Gelen Sayıyı Giriniz: \n");
            h[i] = scn.nextInt();
            hBasla++;
        }
         CategoryChart chart = new CategoryChartBuilder().width(500).height(600).title("GRAFİK TABLOSU").build();
        //Burada Grafik Penceresinin ekranda gözükmesini ayarlıyoruz
        chart.getStyler().setChartTitleVisible(true);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Stick);
        //X Grafiğinin Giriş Grafiği
        chart.addSeries("H[n]", diziHx, h);
        return chart;
    }

   }
}
