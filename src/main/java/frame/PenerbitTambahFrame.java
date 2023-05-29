package frame;

import javax.swing.*;

public class PenerbitTambahFrame extends JFrame {
    int status;
    
    private final int SEDANG_TAMBAH = 101;
    private final int SEDANG_UBAH = 102;
    
    JLabel jLabel1 = new JLabel("id");
    JLabel jLabel2 = new JLabel("Penerbit");
    
    JTextField eId = new JTextField();
    JTextField ePenerbit = new JTextField();
    
    JButton bSimpan = new JButton("Simpan");
    JButton bBatal = new JButton("Batal");
    
    public void setKomponen(){
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        getContentPane().add(jLabel2);
        getContentPane().add(eId);
        getContentPane().add(ePenerbit);
        getContentPane().add(bSimpan);
        getContentPane().add(bBatal);
        
        jLabel1.setBounds(70,10,50,25);
        jLabel2.setBounds(30,40,50,25);
        
        eId.setBounds(100,10,50,25);
        ePenerbit.setBounds(100,40,270,25);
        
        bSimpan.setBounds(160,70,100,25);
        bBatal.setBounds(270,70,100,25);
        
        eId.setEditable(false);
        setVisible(true);
        ePenerbit.requestFocus();
    }
}
