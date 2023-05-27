package frame;

import javax.swing.*;
import javax.swing.table.*;
import model.Penerbit;

public class PenerbitTampilFrame extends JFrame{
    JLabel jLabel1 = new JLabel("Cari");
    JTextField eCari = new JTextField();
    JButton bCari = new JButton("Cari");
    
    String header [] = {"Id","Penerbit"};
    TableModel tableModel = new DefaultTableModel(header, 0);
    JTable tPenerbit = new JTable(tableModel);
    JScrollPane jScrollPane = new JScrollPane(tPenerbit);
    
    JButton bTambah = new JButton("Tambah");
    JButton bUbah = new JButton("Ubah");
    JButton bHapus = new JButton("Hapus");
    JButton bBatal = new JButton("Batal");
    JButton bTutup = new JButton("Tutup");
    
    Penerbit penerbit;
    
    public void setKomponen(){
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        getContentPane().add(eCari);
        getContentPane().add(jScrollPane);
        getContentPane().add(bCari);
        getContentPane().add(bTambah);
        getContentPane().add(bUbah);
        getContentPane().add(bHapus);
        getContentPane().add(bBatal);
        getContentPane().add(bTutup);

        jLabel1.setBounds(10,10,50,25);
        eCari.setBounds(60,10,330,25);
        bCari.setBounds(400,10,70,25);
        bTutup.setBounds(400,220,70,25);
        bTambah.setBounds(170,220,80,25);
        bUbah.setBounds(95,220,70,25);
        bHapus.setBounds(170,220,70,25);
        bBatal.setBounds(245,220,70,25);
        jScrollPane.setBounds(10,45,460,160);

        setVisible(true);
    }

    public PenerbitTampilFrame() {
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setKomponen();
    }
    
    
}



