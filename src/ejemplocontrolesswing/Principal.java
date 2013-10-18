package ejemplocontrolesswing;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Principal  extends JFrame {
    public JTable tabla;
    public Principal(String titulo) {
        super(titulo);        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setSize(dimension);
        setLayout(null);
        
        // Defino los datos que iran en la tabla
        String[] columnas = {"Nombre","Apellido","DNI","Domicilio"};        
        Object[][] datos = {
            {"Juan", "Perez",new Integer(335638542),"Sarmiento 44"},
            {"Ariel", "Luna",new Integer(205421588),"Esquiu 126"},
            {"Pedro", "Sanchez",new Integer(105421511),"Zurita 10"},
            {"Ana", "Ramirez",new Integer(245421512),"Belgrano 600"},
            {"Maria", "Fernandez",new Integer(335421513),"San Martin 34"},
            {"Soledad", "Segovia",new Integer(255421514),"Chacabuco 656"},
            {"Hector", "Maldonado",new Integer(315421515),"Prado 456"},
        };        
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        
        // Asocio la Tabla con el modelo que tiene los datos a mostrar        
        tabla = new JTable(modelo);
        
        
        // Agrego por si necesito un Listener                
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evnt) {
                if (evnt.getClickCount() > 1) {
                    //Muestra la fila y columna numero 2 seleccionada cuando se hace doble-click con el mouse
                    System.out.println(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
                }
            }
        });        
        
        // Agrego un panel que contiene a la tabla y nos da la barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(new Rectangle(400,100));
        scrollPane.setLocation(100,100);                
        this.add(scrollPane);
        
        
        // Agrego un boton para tomar el elemento seleccionado en la tabla        
        JButton button = new JButton("Ver Valor Seleccionado");        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,tabla.getValueAt(tabla.getSelectedRow(),tabla.getSelectedColumn()).toString());
            }
        });             
        button.setBounds(new Rectangle(180, 50));        
        button.setLocation(160, 210);        
        this.add(button);
        
        setVisible(true);                
        
    }
}
