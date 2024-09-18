import java.util.Scanner;

public class Tugas1_B1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan Nama Kau : ");
        String nama = scanner.nextLine(); 
        
        System.out.print("Masukkan Akhiran NIM Kau : ");
        int NIM = scanner.nextInt();  
        
        System.out.println("\nData yang Kau masukkan adalah:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + "231402" + (String.format("%03d",NIM)));
        

        scanner.close();
    }
}
