public class Diskon extends MenuItem {
    private double Diskon;

    public Diskon(String nama, double harga, String kategori, double Diskon){
        super (nama, harga, kategori);
        this.Diskon = Diskon;
    }
    public double getDiskon(){
        return Diskon;
    }
    @Override 
    public void TampilkanMenu(){
        System.out.println("Diskon : " + getNama() + " | Potongan : " + Diskon + "%");
    }
}
