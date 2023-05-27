package frame;

import db.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
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

        resetTable("");
        setVisible(true);
    }

    public PenerbitTampilFrame() {
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setKomponen();
    }
    
    public static void main(String[] args) {
        PenerbitTampilFrame penerbitTampilFrame = new PenerbitTampilFrame();
    }
    
    public ArrayList<Penerbit> getPenerbitList(String keyword){
        ArrayList<Penerbit> penerbitList = new ArrayList<Penerbit>();
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();
        
        String query = "Sellect * From penerbit"+keyword;
        Statement statement;
        ResultSet resultSet;
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        penerbit = new Penerbit(resultSet.getInt("id"),
                                resultSet.getString("penerbit"));
                        penerbitList.add(penerbit);
                    }
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Koneksi Null Gagal");
        }
        return penerbitList;
    }
    
    public final void selectPenerbit(String keyword){
        ArrayList<Penerbit> list = getPenerbitList(keyword);
        DefaultTableModel model = (DefaultTableModel)tPenerbit.getModel();
        Object[] row = new Object[2];
        
        for (int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getPenerbit();
            
            model.addRow(row);
        }
    }
    
    public final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tPenerbit.getModel();
        model.setRowCount(0);
        selectPenerbit(keyword);
    }
    
    public void setListener(){
        bTutup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose(); 
            }
        });
    }
    
}