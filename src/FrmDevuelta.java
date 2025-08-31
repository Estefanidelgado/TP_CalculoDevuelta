import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;



public class FrmDevuelta extends JFrame {
    
    //variables globales 
    private int[] denominacion = new int[]{100000, 50000,20000,10000, 5000, 2000, 1000, 500, 200, 100, 50};
    private int[] existencia = new int[denominacion.length];
    private JComboBox cmbDenominacion;  
    private JTextField txtExistencia;
    private JTextField txtDevuelta; 
    private String[] encabezado = new String[]{" Cantidad", "Presentacion","Denominacion"};
    
    //metodo constructor
   public FrmDevuelta() {
     setTitle("calculo de devueltas");
     setSize(500,400);
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     //siempre que utilices bounds debes de colocar:
     setLayout(null); 

    

      
     // Agregar una etiqueta
     JLabel lblDenominacion =new JLabel("Denominacion:");
     lblDenominacion.setBounds(100,10,100,15);
     getContentPane().add(lblDenominacion);

     // lista desplegable con todas las numeraciones
     cmbDenominacion = new JComboBox();    
     cmbDenominacion.setBounds(200,10,100,15);
     getContentPane().add(cmbDenominacion);

     // crear un modelo de datos para la lista desplegable
     String[]strDenominacion = new String[denominacion.length];
     for (int i=0; i<denominacion.length; i ++){
       strDenominacion[i] = String.valueOf(denominacion[i]);     
      }
    cmbDenominacion.setModel(new DefaultComboBoxModel(strDenominacion));

     // agregar un boton 
    JButton btnActualizarExistencia = new JButton("Äctualizar Existencia");
    btnActualizarExistencia.setBounds(10,40,170,25);
    getContentPane().add(btnActualizarExistencia);

    // Agregar una caja de texto 
    txtExistencia = new JTextField();
    txtExistencia.setBounds(200,40,100,25);
    getContentPane().add(txtExistencia);

    //agregar los eventos para actualizar las existencias 
    cmbDenominacion.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        consultarExistencia();
       
      }
    });

    btnActualizarExistencia.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        actualizarExistencia();
      }
    });

    //agregar metodos para leer la devuelta
    JLabel lblDevuelta =new JLabel("Devuelta:");
     lblDevuelta.setBounds(10,70,100,25);
     getContentPane().add(lblDevuelta);
     // Agregar una caja de texto 
    txtDevuelta = new JTextField();
    txtDevuelta.setBounds(150,70,100,25);
    getContentPane().add(txtDevuelta);
    // agregar un boton 
    JButton btnDevuelta = new JButton("Calcular");
    btnDevuelta.setBounds(260,70,100,25);
    getContentPane().add(btnDevuelta);
    //agregar rejilla de datos
    JTable tblDevuelta = new JTable();
    JScrollPane spDevuelta = new JScrollPane(tblDevuelta);
    spDevuelta.setBounds(10,100,450,200);
    getContentPane().add(spDevuelta);

    //asignar el modelo de datos de la rejilla
    DefaultTableModel dtm = new DefaultTableModel(null, encabezado);
    tblDevuelta.setModel(dtm);

    }

  private void consultarExistencia(){
    int existenciaActual = existencia[cmbDenominacion.getSelectedIndex()];
    txtExistencia.setText(String.valueOf(existenciaActual));




  }
  private void actualizarExistencia(){
    int existenciaActual = Integer.parseInt(txtExistencia.getText());
    existencia[cmbDenominacion.getSelectedIndex()] = existenciaActual;
  



  }

}

