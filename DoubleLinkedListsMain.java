
import java.util.Scanner;

public class DoubleLinkedListsMain {

    public static void main(String[] args) {
        DoubleLinkedLists dll = new DoubleLinkedLists();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Tambah setelah NIM tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1: {
                    Mahasiswa23 mhs = inputMahasiswa(scan);
                    dll.addFirst(mhs);
                    break;
                }
                case 2: {
                    Mahasiswa23 mhs = inputMahasiswa(scan);
                    dll.addLast(mhs);
                    break;
                }
                case 3:
                    // dll.removeFirst();
                    break;
                case 4:
                    // dll.removeLast();
                    break;
                case 5:
                    dll.print();
                    break;
                case 6:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = scan.nextLine();
                    Mahasiswa23 mhsDitemukan = dll.findMahasiswaByNim(nimCari);
                    if (mhsDitemukan != null) {
                        System.out.println("Mahasiswa ditemukan:");
                        mhsDitemukan.tampil();
                    } else {
                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;
                case 7: {
                    System.out.print("Masukkan NIM yang menjadi acuan: ");
                    String nimTarget = scan.nextLine();
                    Mahasiswa23 targetMhs = dll.findMahasiswaByNim(nimTarget);
                    if (targetMhs == null) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    } else {
                        System.out.println("Masukkan data Mahasiswa yang akan disisipkan:");
                        Mahasiswa23 dataBaru = inputMahasiswa(scan);
                        dll.insertAfter(targetMhs, dataBaru);
                    }
                    break;
                }
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        scan.close();
    }

    public static Mahasiswa23 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM: ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK: ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa23(nim, nama, kelas, ipk);
    }
}
