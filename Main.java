import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        Menu Menu = new Menu();
        Pesanan Pesanan = new Pesanan();

        int Pilihan;

        do{
            System.out.println("\n==== Manajemen Restoran ====");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Pesan");
            System.out.println("4. Hitung Total Pesanan");
            System.out.println("5. Cetak Struk Pesanan");
            System.out.println("6. Simpan Menu");
            System.out.println("7. Keluar");
            System.out.print("Pilih : ");

            Pilihan = input.nextInt();
            input.nextLine();
            
            switch(Pilihan){
                case 1:
                    System.out.println("1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.println("3. Diskon");

                    int jenis = input.nextInt();
                    input.nextLine();

                    System.out.print("Nama menu : ");
                    String nama = input.nextLine();

                    System.out.print("Tambahkan harga : ");
                    double harga = input.nextDouble();
                    input.nextLine();

                    if(jenis == 1){
                        System.out.print("Jenis makanan :");
                        String jenisMakanan = input.nextLine();

                        Menu.tambahMenu(new Makanan(nama, harga,"Makanan", jenisMakanan));
                    }else if(jenis == 2 ){
                        System.out.print("Jenis minuman : ");
                        String jenisMinuman = input.nextLine();
                        Menu.tambahMenu(new Minuman(nama, harga,"Minuman",jenisMinuman));
                    }else if(jenis == 3){
                        System.out.print("Diskon(%) : ");
                        double Diskon = input.nextDouble();
                        Menu.tambahMenu(new Diskon(nama, harga, "Diskon", Diskon));

                    }
                    break;
                case 2:
                    Menu.TampilkanSemuaMenu();
                    break; 
                case 3:
                    try{
                        Menu.TampilkanSemuaMenu();

                        System.out.print("Pilih nomor menu : ");
                        int nomor = input.nextInt();

                        Pesanan.TambahPesanan(Menu.getItem(nomor - 1));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("total pembayaran = Rp" + Pesanan.HitungTotal());
                    break;
                case 5:
                    Pesanan.TampilkanStruk();
                    Pesanan.SimpanStruk();
                    break;
                case 6 :
                    Menu.SimpanMenu();
                    break;
                case 7 :
                    System.out.println("Proses selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");

            }

        }while(Pilihan != 7);

        input.close();
    }
}
