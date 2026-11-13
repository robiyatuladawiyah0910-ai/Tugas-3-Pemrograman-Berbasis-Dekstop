import java.util.ArrayList;
import java.io.*;

public class Menu{
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    public void tambahMenu(MenuItem Item){
        daftarMenu.add(Item);
    }
    public void TampilkanSemuaMenu(){
        for(int i = 0; i<daftarMenu.size(); i++){
            System.out.print((i+1)+".");
            daftarMenu.get(i).TampilkanMenu();
        }

    }

public MenuItem getItem(int index) throws Exception{
    if (index <0 || index >= daftarMenu.size()){
        throw new Exception("Menu tersebut tidak ditemukan");
    }
    return daftarMenu.get(index);

}

public void SimpanMenu(){
    try(PrintWriter pw = new PrintWriter("menu.txt")){
        for(MenuItem Item: daftarMenu){
            pw.println(Item.getNama() + "," + Item.getHarga());
        }
        System.out.println("Menu berhasil disimpan ke dalam file menu.txt");
    } catch (Exception e){
        System.out.println(e.getMessage());
    }
   
    

}
}