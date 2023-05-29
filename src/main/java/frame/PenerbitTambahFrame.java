package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Penerbit;

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
    
    public PenerbitTambahFrame(){
        status = SEDANG_TAMBAH;
        setSize(420,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setKomponen();
    }
    
    public PenerbitTambahFrame(Penerbit penerbit){
        status = SEDANG_UBAH;
        setSize(420,180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        eId.setText(String.valueOf(penerbit.getId()));
        ePenerbit.setText((String) penerbit.getPenerbit());
        setKomponen();
    }
    
    public void setListener(){
        bBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
}

