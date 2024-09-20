import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tugas2_B1 {
    private static Map<String, String> mahasiswaMap = new HashMap<>();


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
        
            System.out.println("===== Menu CRUD Mahasiswa =====");
            System.out.println("1. Create Mahasiswa");
            System.out.println("2. Read Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Delete Mahasiswa");
            System.out.println("5. Exit");
            System.out.print("Pilih menu (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    createMahasiswa();
                    break;
                case 2:
                    readMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    deleteMahasiswa();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        } while (pilihan != 5);
    }

    private static void createMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();

        if (mahasiswaMap.containsKey(nim)) {
            System.out.println("NIM sudah terdaftar!");
        } else {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            mahasiswaMap.put(nim, nama);
            System.out.println("Mahasiswa berhasil ditambahkan.");
        }
    }

    private static void readMahasiswa() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Belum ada mahasiswa yang terdaftar.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            for (Map.Entry<String, String> entry : mahasiswaMap.entrySet()) {
                System.out.println("NIM: " + entry.getKey() + ", Nama: " + entry.getValue());
            }
        }
    }

    private static void updateMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
        String nim = scanner.nextLine();

        if (mahasiswaMap.containsKey(nim)) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            mahasiswaMap.put(nim, namaBaru);
            System.out.println("Data mahasiswa berhasil diupdate.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }


    private static void deleteMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        if (mahasiswaMap.containsKey(nim)) {
            mahasiswaMap.remove(nim);
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }
}