
public class DoubleLinkedLists {

    Node23 head, tail;

    public DoubleLinkedLists() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa23 data) {
        Node23 newNode = new Node23(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa23 data) {
        Node23 newNode = new Node23(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(Mahasiswa23 target, Mahasiswa23 data) {
        Node23 current = head;
        while (current != null && !current.data.nim.equals(target.nim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + target.nim + " tidak ditemukan.");
            return;
        }

        Node23 newNode = new Node23(data);

        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node dengan NIM " + target.nim + " telah berhasil ditambahkan.");
    }

    public void print() {
        if (head == null) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        Node23 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public Mahasiswa23 findMahasiswaByNim(String nim) {
        Node23 current = head;
        while (current != null) {
            if (current.data.nim.equalsIgnoreCase(nim)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        Mahasiswa23 dataTerhapus = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah: " + dataTerhapus);
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        Mahasiswa23 dataTerhapus = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah: " + dataTerhapus);
    }

    public void add(Mahasiswa23 data, int index) {
        if (index < 0 || index > size()) {
            System.out.println("Indeks tidak valid");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size()) {
            addLast(data);
            return;
        }
        Node23 newNode = new Node23(data);
        Node23 current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        System.out.println("Data berhasil ditambahkan di indeks ke-" + index);
    }

    public void removeAfter(Mahasiswa23 key) {
        Node23 current = head;
        while (current != null && !current.data.nim.equals(key.nim)) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node setelah NIM tersebut tidak ditemukan atau kosong.");
            return;
        }
        Mahasiswa23 hapus = current.next.data;
        if (current.next == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = current.next.next;
            current.next.prev = current;
        }
        System.out.println("Node setelah NIM " + key.nim + " berhasil dihapus. Data: " + hapus.nim + ", " + hapus.nama);
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size() - 1) {
            removeLast();
            return;
        }
        Node23 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Mahasiswa23 hapus = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Data di indeks ke-" + index + " berhasil dihapus. Data: " + hapus.nim + ", " + hapus.nama);
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("List kosong");
        } else {
            System.out.println("Data pertama:");
            head.data.tampil();
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("List kosong");
        } else {
            System.out.println("Data terakhir:");
            tail.data.tampil();
        }
    }

    public void getIndex(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node23 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data pada indeks ke-" + index + ":");
        current.data.tampil();
    }

    public int size() {
        int count = 0;
        Node23 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
