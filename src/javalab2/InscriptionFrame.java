/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author atdig
 */
class InscriptionFrame extends JFrame implements ActionListener{
    //Initial variables for data oprations (Set user input value as globle variable we can use it in the class)
    String user_sexe = "";
    String user_ville = "";

    JButton button;
    JTextField code_field;
    JTextField nom_field;
    JTextField prenom_field;
    JRadioButton sexe_btn_homme, sexe_btn_femme;
    JTextArea txa_address;
    JComboBox comb_ville;
    
    InscriptionFrame(){
        //Set main container
       this.setSize(800, 800);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new BorderLayout());
       
       //Set top body bottom for the form
       JPanel panel_title = new JPanel();
       JPanel panel_form = new JPanel();
       JPanel panel_button = new JPanel();
       
       //Add layout to main container
       this.add(panel_title, BorderLayout.NORTH);
       this.add(panel_form, BorderLayout.CENTER);
       this.add(panel_button, BorderLayout.SOUTH);
       
       //Top: title
       JLabel title = new JLabel("Inscription");
       title.setFont(new Font("Arial", Font.BOLD, 24));
       panel_title.add(title);
       panel_title.setBorder(new EmptyBorder(20, 20, 20, 20));
       
       //Body: from separate to left and right two parts
       panel_form.setLayout(new FlowLayout());
         //panel_form.setBackground(Color.GREEN);
        
       //From left separate to top and bottom two parts  
       JPanel form_left = new JPanel();
       form_left.setLayout(new BoxLayout(form_left, BoxLayout.Y_AXIS));
       panel_form.add(form_left);
       form_left.setBorder(new EmptyBorder(20, 20, 20, 20));
       
       //Form left top holding the 3 rows and 2 columns 
       JPanel form_l_top = new JPanel();
       form_left.add(form_l_top);
       form_l_top.setLayout(new GridLayout(3, 2, 20, 20));
       form_l_top.setBorder(new EmptyBorder(20, 20, 20, 20));
       
       //Code Permanent
       JLabel code = new JLabel("Code Permanent");
       form_l_top.add(code);       
       code_field = new JTextField();
       form_l_top.add(code_field);
       
       //Nom
       JLabel nom = new JLabel("Nom");
       form_l_top.add(nom);      
       nom_field = new JTextField();
       form_l_top.add(nom_field);
       
       //Prenom
       JLabel prenom = new JLabel("Prenom");
       form_l_top.add(prenom);      
       prenom_field = new JTextField();
       form_l_top.add(prenom_field);
       
       //Form left bottom holding the 1 rows and 3 columns 
       JPanel form_l_bottom = new JPanel();
       form_left.add(form_l_bottom);
       form_l_bottom.setLayout(new GridLayout(1, 3));
       form_l_bottom.setBorder(new EmptyBorder(20, 20, 20, 20));
       
        //Sexe
       JLabel sexe = new JLabel("Sexe");
       form_l_bottom.add(sexe);     
       sexe_btn_homme = new JRadioButton("Homme");
       form_l_bottom.add(sexe_btn_homme);     
       sexe_btn_femme = new JRadioButton("Femme");
       form_l_bottom.add(sexe_btn_femme);
       
       sexe_btn_homme.addActionListener(this);
       sexe_btn_femme.addActionListener(this);     
       
       ButtonGroup group = new ButtonGroup();
       group.add(sexe_btn_homme);
       group.add(sexe_btn_femme);
               
       
       //Form right parts holding 2 rows and 2 columns
       JPanel form_right = new JPanel();
       form_right.setLayout(new BorderLayout());
       panel_form.add(form_right);
       form_right.setBorder(new EmptyBorder(20, 20, 20, 20));
       
       JPanel form_r_top = new JPanel();
       form_right.add(form_r_top, BorderLayout.NORTH);
       form_r_top.setLayout(new GridLayout(1, 2, 0, 20));
       form_r_top.setBorder(new EmptyBorder(0, 0, 0, 0));
       
       //Address
       JLabel address = new JLabel("Address");
       form_r_top.add(address);
       txa_address = new JTextArea(5, 10);
       form_r_top.add(txa_address);
       
       JPanel form_r_bottom = new JPanel();
       form_right.add(form_r_bottom, BorderLayout.SOUTH);
       form_r_bottom.setLayout(new GridLayout(1, 2, 0, 20));
       form_r_bottom.setBorder(new EmptyBorder(60, 0, 0, 0));

       //Ville
       String[] villes = {"Montreal", "Laval", "Terrebonne", "Longueuil", "Trois Rivieres"};
       JLabel ville = new JLabel("Ville");
       form_r_bottom.add(ville);
       comb_ville = new JComboBox(villes);
       comb_ville.setSelectedItem("Montreal");
       form_r_bottom.add(comb_ville);
       comb_ville.addActionListener(this);
       
       
       //Bottom: button
       button = new JButton("SOUMETTRE");
       panel_button.add(button);
       panel_button.setBorder(new EmptyBorder(20, 20, 20, 20));
       button.addActionListener(this);
       
       
       //this.pack();
       this.setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {                       
        if (e.getSource() == button){                      
            System.out.println("Code Permanent : " + code_field.getText());
            System.out.println("Nom : " + nom_field.getText());
            System.out.println("Prenom : " + prenom_field.getText());
            System.out.println("Sexe : " + sexe_btn_homme.getText());
            System.out.println("Address : " + txa_address.getText());
            System.out.println("Ville : " + comb_ville.getSelectedItem().toString());
        }
        
    }
    
}

