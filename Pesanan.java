import java .util.ArrayList;
import java.io.*;

public class Pesanan{
    private ArrayList<MenuItem> Pesanan = new ArrayList<>();

    public void TambahPesanan(MenuItem Item){
        Pesanan.add(Item);

    }
    public double HitungTotal(){
        double Total = 0;
        double Diskon = 0;

        for(MenuItem Item : Pesanan){
            if(Item instanceof Diskon){
                Diskon = ((Diskon)Item).getDiskon();
            }else{
                Total += Item.getHarga();
            }
        }
        Total = Total - (Total * Diskon / 100);
        return Total;

    }

    public void TampilkanStruk(){
        System.out.println("\n===== STRUK PESANAN =====");

        for(MenuItem Item : Pesanan){
            Item.TampilkanMenu();
        }
        System.out.println("Total Pembayaran : Rp" + HitungTotal());
    }

    public void SimpanStruk(){
        try(PrintWriter pw = new PrintWriter("Struk.txt")){
            pw.println("==== STRUK PESANAN ====");

            for (MenuItem Item : Pesanan){
                pw.println(Item.getNama() + " Rp" + Item.getHarga());
            }
            pw.println("Total : Rp" + HitungTotal());
            System.out.println("Struk berhasil disimpan");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
