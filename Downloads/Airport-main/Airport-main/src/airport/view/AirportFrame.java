/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airport.view;

import airport.controller.AirportController;
import airport.controller.Flight_Controller;
import airport.controller.Location_Controller;
import airport.controller.Passenger_Controller;
import airport.controller.Plane_Controller;
import airport.controller.interfaces.FlightControllerInterface;
import airport.controller.interfaces.LocationControllerInterface;
import airport.controller.interfaces.PassengerControllerInterface;
import airport.controller.interfaces.PlaneControllerInterface;
import airport.model.Flight;
import airport.model.Location;
import airport.model.Passenger;
import airport.model.Plane;
import airport.service.FlightService;
import airport.service.LocationService;
import airport.service.PassengerService;
import airport.service.PlaneService;
import airport.service.validator.impl.FlightValidator;
import airport.service.validator.impl.LocationValidator;
import airport.service.validator.impl.PassengerValidator;
import airport.service.validator.impl.PlaneValidator;
import airport.service.validator.interfaces.ValidatorInterface;
import airport.storage.impl.StorageFlightImpl;
import airport.storage.impl.StorageLocationImpl;
import airport.storage.impl.StoragePassengerImpl;
import airport.storage.impl.StoragePlaneImpl;
import airport.storage.interfaces.StorageFlight;
import airport.storage.interfaces.StorageLocation;
import airport.storage.interfaces.StoragePassenger;
import airport.storage.interfaces.StoragePlane;
import airport.utils.JsonLoader;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import airport.view.PanelRound;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import airport.controller.Response;
import airport.model.Passenger;
import java.util.List;

/**
 *
 * @author edangulo
 */
public class AirportFrame extends javax.swing.JFrame {

    private int x, y;
    private final AirportController controller;

    public AirportFrame(AirportController controller) {
        this.controller = controller;
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.generateMonths();
        this.generateDays();
        this.generateHours();
        this.generateMinutes();
        this.blockPanels();
        this.cargarComboBoxPasajeros();
        this.cargarComboBoxFlights();
        this.cargarComboBoxPlanes();
        cargarComboBoxLocations(ComboBoxLocation1);
        cargarComboBoxLocations(ComboBoxLocation2);
        cargarComboBoxLocations(ComboBoxLocation3);
    }

    private void cargarComboBoxPasajeros() {
        userSelect.removeAllItems();
        userSelect.addItem("Seleccione un pasajero");
        Response<List<Passenger>> response = controller.getAllPassengers();
        if (response != null && response.getStatus() == 200 && response.getData() != null) {
            for (Passenger p : response.getData()) {
                userSelect.addItem(String.valueOf(p.getId()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar pasajeros: "
                    + (response != null ? response.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void blockPanels() {
        // 9, 11
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
            if (i != 9 && i != 11) {
                jTabbedPane1.setEnabledAt(i, false);
            }
        }
    }

    private void generateMonths() {
        for (int i = 1; i < 13; i++) {
            MONTH.addItem("" + i);
            MONTH1.addItem("" + i);
            MONTH5.addItem("" + i);
        }
    }

    private void generateDays() {
        for (int i = 1; i < 32; i++) {
            DAY.addItem("" + i);
            DAY1.addItem("" + i);
            DAY5.addItem("" + i);
        }
    }

    private void generateHours() {
        for (int i = 0; i < 24; i++) {
            MONTH2.addItem("" + i);
            MONTH3.addItem("" + i);
            MONTH4.addItem("" + i);
            ComboBoxHour.addItem("" + i);
        }
    }

    private void generateMinutes() {
        for (int i = 0; i < 60; i++) {
            DAY2.addItem("" + i);
            DAY3.addItem("" + i);
            DAY4.addItem("" + i);
            ComboBoxMinute.addItem("" + i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panelRound1 = new airport.view.PanelRound();
                panelRound2 = new airport.view.PanelRound();
                jButton13 = new javax.swing.JButton();
                jTabbedPane1 = new javax.swing.JTabbedPane();
                jPanel1 = new javax.swing.JPanel();
                user = new javax.swing.JRadioButton();
                administrator = new javax.swing.JRadioButton();
                userSelect = new javax.swing.JComboBox<>();
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                PhoneZonetxt = new javax.swing.JTextField();
                IDPassengertxt = new javax.swing.JTextField();
                BirthDatetxt = new javax.swing.JTextField();
                Countrytxt = new javax.swing.JTextField();
                PhoneNumbertxt = new javax.swing.JTextField();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                LastNametxt = new javax.swing.JTextField();
                jLabel9 = new javax.swing.JLabel();
                MONTH = new javax.swing.JComboBox<>();
                FirstNametxt = new javax.swing.JTextField();
                jLabel10 = new javax.swing.JLabel();
                DAY = new javax.swing.JComboBox<>();
                RegisterPassenger = new javax.swing.JButton();
                jPanel3 = new javax.swing.JPanel();
                jLabel11 = new javax.swing.JLabel();
                IDPlanetxt = new javax.swing.JTextField();
                jLabel12 = new javax.swing.JLabel();
                Brandtxt = new javax.swing.JTextField();
                Modeltxt = new javax.swing.JTextField();
                jLabel13 = new javax.swing.JLabel();
                MaxCapacitytxt = new javax.swing.JTextField();
                jLabel14 = new javax.swing.JLabel();
                Airlinetxt = new javax.swing.JTextField();
                jLabel15 = new javax.swing.JLabel();
                CreateAirplane = new javax.swing.JButton();
                jPanel13 = new javax.swing.JPanel();
                jLabel16 = new javax.swing.JLabel();
                AirportIDtxt = new javax.swing.JTextField();
                jLabel17 = new javax.swing.JLabel();
                AirportNametxt = new javax.swing.JTextField();
                AirportCitytxt = new javax.swing.JTextField();
                jLabel18 = new javax.swing.JLabel();
                jLabel19 = new javax.swing.JLabel();
                AirportCountrytxt = new javax.swing.JTextField();
                AirportLatitudetxt = new javax.swing.JTextField();
                jLabel20 = new javax.swing.JLabel();
                jLabel21 = new javax.swing.JLabel();
                AirportLongitudetxt = new javax.swing.JTextField();
                CreateLocation = new javax.swing.JButton();
                jPanel4 = new javax.swing.JPanel();
                jLabel22 = new javax.swing.JLabel();
                IDflight = new javax.swing.JTextField();
                jLabel23 = new javax.swing.JLabel();
                ComboBoxPlane = new javax.swing.JComboBox<>();
                ComboBoxLocation1 = new javax.swing.JComboBox<>();
                jLabel24 = new javax.swing.JLabel();
                ComboBoxLocation2 = new javax.swing.JComboBox<>();
                jLabel25 = new javax.swing.JLabel();
                jLabel26 = new javax.swing.JLabel();
                ComboBoxLocation3 = new javax.swing.JComboBox<>();
                jLabel27 = new javax.swing.JLabel();
                jLabel28 = new javax.swing.JLabel();
                jLabel29 = new javax.swing.JLabel();
                DepartureDatetxt = new javax.swing.JTextField();
                jLabel30 = new javax.swing.JLabel();
                MONTH1 = new javax.swing.JComboBox<>();
                jLabel31 = new javax.swing.JLabel();
                DAY1 = new javax.swing.JComboBox<>();
                jLabel32 = new javax.swing.JLabel();
                MONTH2 = new javax.swing.JComboBox<>();
                jLabel33 = new javax.swing.JLabel();
                DAY2 = new javax.swing.JComboBox<>();
                MONTH3 = new javax.swing.JComboBox<>();
                jLabel34 = new javax.swing.JLabel();
                DAY3 = new javax.swing.JComboBox<>();
                jLabel35 = new javax.swing.JLabel();
                MONTH4 = new javax.swing.JComboBox<>();
                DAY4 = new javax.swing.JComboBox<>();
                CreateFlight = new javax.swing.JButton();
                jPanel5 = new javax.swing.JPanel();
                jLabel36 = new javax.swing.JLabel();
                IDUpdatetxt = new javax.swing.JTextField();
                jLabel37 = new javax.swing.JLabel();
                FirstNameUpdatetxt = new javax.swing.JTextField();
                jLabel38 = new javax.swing.JLabel();
                LastNameUpdatetxt = new javax.swing.JTextField();
                jLabel39 = new javax.swing.JLabel();
                BirthDateUpdatetxt = new javax.swing.JTextField();
                MONTH5 = new javax.swing.JComboBox<>();
                DAY5 = new javax.swing.JComboBox<>();
                PhoneNumberUpdatetxt = new javax.swing.JTextField();
                jLabel40 = new javax.swing.JLabel();
                PhoneZoneUpdatetxt = new javax.swing.JTextField();
                jLabel41 = new javax.swing.JLabel();
                jLabel42 = new javax.swing.JLabel();
                jLabel43 = new javax.swing.JLabel();
                CountryUpdatetxt = new javax.swing.JTextField();
                UpdateInfo = new javax.swing.JButton();
                jPanel7 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jButton2 = new javax.swing.JButton();
                jPanel8 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable();
                jButton3 = new javax.swing.JButton();
                jPanel9 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                jTable3 = new javax.swing.JTable();
                jButton4 = new javax.swing.JButton();
                jPanel10 = new javax.swing.JPanel();
                jButton5 = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                jTable4 = new javax.swing.JTable();
                jPanel11 = new javax.swing.JPanel();
                jScrollPane5 = new javax.swing.JScrollPane();
                jTable5 = new javax.swing.JTable();
                ShowAllLocationsRefreshBTN = new javax.swing.JButton();
                jPanel12 = new javax.swing.JPanel();
                ComboBoxHour = new javax.swing.JComboBox<>();
                jLabel46 = new javax.swing.JLabel();
                jLabel47 = new javax.swing.JLabel();
                ComboBoxID = new javax.swing.JComboBox<>();
                jLabel48 = new javax.swing.JLabel();
                ComboBoxMinute = new javax.swing.JComboBox<>();
                jButton7 = new javax.swing.JButton();
                jPanel6 = new javax.swing.JPanel();
                IDFlightAdd = new javax.swing.JTextField();
                jLabel44 = new javax.swing.JLabel();
                jLabel45 = new javax.swing.JLabel();
                ComboBoxFlight = new javax.swing.JComboBox<>();
                AddToFlight = new javax.swing.JButton();
                panelRound3 = new airport.view.PanelRound();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                panelRound1.setRadius(40);
                panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jButton13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jButton13.setText("X");
                jButton13.setBorderPainted(false);
                jButton13.setContentAreaFilled(false);
                jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                jButton13.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton13ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
                panelRound2.setLayout(panelRound2Layout);
                panelRound2Layout.setHorizontalGroup(
                                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(1083, Short.MAX_VALUE)
                                                                .addComponent(jButton13,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(17, 17, 17)));
                panelRound2Layout.setVerticalGroup(
                                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound2Layout.createSequentialGroup()
                                                                .addComponent(jButton13)
                                                                .addGap(0, 12, Short.MAX_VALUE)));

                panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

                jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                user.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                user.setText("User");
                user.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                userActionPerformed(evt);
                        }
                });
                jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

                administrator.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                administrator.setText("Administrator");
                administrator.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                administratorActionPerformed(evt);
                        }
                });
                jPanel1.add(administrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 164, -1, -1));

                userSelect.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                userSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User" }));
                userSelect.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                userSelectActionPerformed(evt);
                        }
                });
                jPanel1.add(userSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 130, -1));

                jTabbedPane1.addTab("Administration", jPanel1);

                jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel1.setText("Country:");
                jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

                jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel2.setText("ID:");
                jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

                jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel3.setText("First Name:");
                jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

                jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel4.setText("Last Name:");
                jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

                jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel5.setText("Birthdate:");
                jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

                jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel6.setText("+");
                jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 20, -1));

                PhoneZonetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(PhoneZonetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 50, -1));

                IDPassengertxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(IDPassengertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, -1));

                BirthDatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(BirthDatetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, -1));

                Countrytxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(Countrytxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 130, -1));

                PhoneNumbertxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(PhoneNumbertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, -1));

                jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel7.setText("Phone:");
                jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

                jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel8.setText("-");
                jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 30, -1));

                LastNametxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(LastNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 130, -1));

                jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel9.setText("-");
                jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 30, -1));

                MONTH.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                MONTH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));
                jPanel2.add(MONTH, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

                FirstNametxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel2.add(FirstNametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 130, -1));

                jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel10.setText("-");
                jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 30, -1));

                DAY.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                DAY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));
                jPanel2.add(DAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

                RegisterPassenger.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                RegisterPassenger.setText("Register");
                RegisterPassenger.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                RegisterPassengerActionPerformed(evt);
                        }
                });
                jPanel2.add(RegisterPassenger, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

                jTabbedPane1.addTab("Passenger registration", jPanel2);

                jPanel3.setLayout(null);

                jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel11.setText("ID:");
                jPanel3.add(jLabel11);
                jLabel11.setBounds(53, 96, 22, 25);

                IDPlanetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel3.add(IDPlanetxt);
                IDPlanetxt.setBounds(180, 93, 130, 31);

                jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel12.setText("Brand:");
                jPanel3.add(jLabel12);
                jLabel12.setBounds(53, 157, 50, 25);

                Brandtxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel3.add(Brandtxt);
                Brandtxt.setBounds(180, 154, 130, 31);

                Modeltxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel3.add(Modeltxt);
                Modeltxt.setBounds(180, 213, 130, 31);

                jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel13.setText("Model:");
                jPanel3.add(jLabel13);
                jLabel13.setBounds(53, 216, 55, 25);

                MaxCapacitytxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel3.add(MaxCapacitytxt);
                MaxCapacitytxt.setBounds(180, 273, 130, 31);

                jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel14.setText("Max Capacity:");
                jPanel3.add(jLabel14);
                jLabel14.setBounds(53, 276, 109, 25);

                Airlinetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jPanel3.add(Airlinetxt);
                Airlinetxt.setBounds(180, 333, 130, 31);

                jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel15.setText("Airline:");
                jPanel3.add(jLabel15);
                jLabel15.setBounds(53, 336, 70, 25);

                CreateAirplane.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                CreateAirplane.setText("Create");
                CreateAirplane.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                CreateAirplaneActionPerformed(evt);
                        }
                });
                jPanel3.add(CreateAirplane);
                CreateAirplane.setBounds(490, 480, 120, 40);

                jTabbedPane1.addTab("Airplane registration", jPanel3);

                jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel16.setText("Airport ID:");

                AirportIDtxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel17.setText("Airport name:");

                AirportNametxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                AirportCitytxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel18.setText("Airport city:");

                jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel19.setText("Airport country:");

                AirportCountrytxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                AirportLatitudetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel20.setText("Airport latitude:");

                jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel21.setText("Airport longitude:");

                AirportLongitudetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                CreateLocation.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                CreateLocation.setText("Create");
                CreateLocation.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                CreateLocationActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
                jPanel13.setLayout(jPanel13Layout);
                jPanel13Layout.setHorizontalGroup(
                                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel13Layout.createSequentialGroup()
                                                                .addGroup(jPanel13Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel13Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(52, 52, 52)
                                                                                                .addGroup(jPanel13Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel16)
                                                                                                                .addComponent(jLabel17)
                                                                                                                .addComponent(jLabel18)
                                                                                                                .addComponent(jLabel19)
                                                                                                                .addComponent(jLabel20)
                                                                                                                .addComponent(jLabel21))
                                                                                                .addGap(80, 80, 80)
                                                                                                .addGroup(jPanel13Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(AirportLongitudetxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(AirportIDtxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(AirportNametxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(AirportCitytxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(AirportCountrytxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(AirportLatitudetxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(jPanel13Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(515, 515, 515)
                                                                                                .addComponent(CreateLocation,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                120,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(515, 515, 515)));
                jPanel13Layout.setVerticalGroup(
                                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel13Layout.createSequentialGroup()
                                                                .addGap(71, 71, 71)
                                                                .addGroup(jPanel13Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel13Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel16)
                                                                                                .addGap(36, 36, 36)
                                                                                                .addComponent(jLabel17)
                                                                                                .addGap(34, 34, 34)
                                                                                                .addComponent(jLabel18)
                                                                                                .addGap(35, 35, 35)
                                                                                                .addComponent(jLabel19)
                                                                                                .addGap(35, 35, 35)
                                                                                                .addComponent(jLabel20))
                                                                                .addGroup(jPanel13Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(AirportIDtxt,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(30, 30, 30)
                                                                                                .addComponent(AirportNametxt,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(28, 28, 28)
                                                                                                .addComponent(AirportCitytxt,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(AirportCountrytxt,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(AirportLatitudetxt,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(44, 44, 44)
                                                                .addGroup(jPanel13Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel21)
                                                                                .addComponent(AirportLongitudetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                51, Short.MAX_VALUE)
                                                                .addComponent(CreateLocation,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(47, 47, 47)));

                jTabbedPane1.addTab("Location registration", jPanel13);

                jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel22.setText("ID:");

                IDflight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel23.setText("Plane:");

                ComboBoxPlane.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxPlane.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plane" }));
                ComboBoxPlane.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ComboBoxPlaneActionPerformed(evt);
                        }
                });

                ComboBoxLocation1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxLocation1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));
                ComboBoxLocation1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ComboBoxLocation1ActionPerformed(evt);
                        }
                });

                jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel24.setText("Departure location:");

                ComboBoxLocation2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxLocation2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));
                ComboBoxLocation2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ComboBoxLocation2ActionPerformed(evt);
                        }
                });

                jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel25.setText("Arrival location:");

                jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel26.setText("Scale location:");

                ComboBoxLocation3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxLocation3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));
                ComboBoxLocation3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ComboBoxLocation3ActionPerformed(evt);
                        }
                });

                jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel27.setText("Duration:");

                jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel28.setText("Duration:");

                jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel29.setText("Departure date:");

                DepartureDatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel30.setText("-");

                MONTH1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                MONTH1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

                jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel31.setText("-");

                DAY1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                DAY1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

                jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel32.setText("-");

                MONTH2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                MONTH2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

                jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel33.setText("-");

                DAY2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                DAY2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

                MONTH3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                MONTH3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

                jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel34.setText("-");

                DAY3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                DAY3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

                jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel35.setText("-");

                MONTH4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                MONTH4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

                DAY4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                DAY4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

                CreateFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                CreateFlight.setText("Create");
                CreateFlight.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                CreateFlightActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(73, 73, 73)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel26)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(ComboBoxLocation3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                130,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                jPanel4Layout.createSequentialGroup()
                                                                                                                .addComponent(jLabel25)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(ComboBoxLocation2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                130,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel24)
                                                                                                .addGap(46, 46, 46)
                                                                                                .addComponent(ComboBoxLocation1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                130,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel22)
                                                                                                                .addComponent(jLabel23))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(IDflight)
                                                                                                                .addComponent(ComboBoxPlane,
                                                                                                                                0,
                                                                                                                                130,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addGap(45, 45, 45)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel27)
                                                                                .addComponent(jLabel28)
                                                                                .addComponent(jLabel29))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(DepartureDatetxt,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                90,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(10, 10, 10)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(MONTH1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jLabel30,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                30,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(14, 14, 14)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel31,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                30,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(DAY1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(MONTH2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jLabel32,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                30,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(14, 14, 14)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel33,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                30,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(DAY2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(30, 30, 30))
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(MONTH3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(14, 14, 14)
                                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel34,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                30,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                                                .addComponent(DAY3,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(MONTH4,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(14, 14, 14)
                                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel35,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                30,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                                                .addComponent(DAY4,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(CreateFlight,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                120,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(530, 530, 530)));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(3, 3, 3)
                                                                                                .addComponent(jLabel22))
                                                                                .addComponent(IDflight,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel23)
                                                                                .addComponent(ComboBoxPlane,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(MONTH2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel32)
                                                                                .addComponent(jLabel33)
                                                                                .addComponent(DAY2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jLabel24)
                                                                                                                                .addComponent(ComboBoxLocation1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel29))
                                                                                                                .addComponent(DepartureDatetxt,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(MONTH1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel30)
                                                                                                                .addComponent(jLabel31)
                                                                                                                .addComponent(DAY1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(38, 38, 38)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jLabel25)
                                                                                                                                .addComponent(ComboBoxLocation2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel28))
                                                                                                                .addComponent(MONTH3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel34)
                                                                                                                .addComponent(DAY3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(34, 34, 34)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(MONTH4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel35)
                                                                                                                .addComponent(DAY4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jPanel4Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                                .addComponent(jLabel26)
                                                                                                                                .addComponent(ComboBoxLocation3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel27)))))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                134, Short.MAX_VALUE)
                                                                .addComponent(CreateFlight,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50)));

                jTabbedPane1.addTab("Flight registration", jPanel4);

                jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel36.setText("ID:");

                IDUpdatetxt.setEditable(false);
                IDUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                IDUpdatetxt.setEnabled(false);

                jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel37.setText("First Name:");

                FirstNameUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel38.setText("Last Name:");

                LastNameUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel39.setText("Birthdate:");

                BirthDateUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                MONTH5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                MONTH5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

                DAY5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                DAY5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

                PhoneNumberUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel40.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel40.setText("-");

                PhoneZoneUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                jLabel41.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel41.setText("+");

                jLabel42.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel42.setText("Phone:");

                jLabel43.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel43.setText("Country:");

                CountryUpdatetxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

                UpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                UpdateInfo.setText("Update");
                UpdateInfo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                UpdateInfoActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(72, 72, 72)
                                                                                                .addGroup(jPanel5Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel36)
                                                                                                                                .addGap(108, 108,
                                                                                                                                                108)
                                                                                                                                .addComponent(IDUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                130,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel37)
                                                                                                                                .addGap(41, 41, 41)
                                                                                                                                .addComponent(FirstNameUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                130,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel38)
                                                                                                                                .addGap(43, 43, 43)
                                                                                                                                .addComponent(LastNameUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                130,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel39)
                                                                                                                                .addGap(55, 55, 55)
                                                                                                                                .addComponent(BirthDateUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(30, 30, 30)
                                                                                                                                .addComponent(MONTH5,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(34, 34, 34)
                                                                                                                                .addComponent(DAY5,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel42)
                                                                                                                                .addGap(56, 56, 56)
                                                                                                                                .addComponent(jLabel41,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                20,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, 0)
                                                                                                                                .addComponent(PhoneZoneUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                50,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(jLabel40,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                30,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, 0)
                                                                                                                                .addComponent(PhoneNumberUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                130,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel5Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabel43)
                                                                                                                                .addGap(63, 63, 63)
                                                                                                                                .addComponent(CountryUpdatetxt,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                130,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addGroup(jPanel5Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(507, 507, 507)
                                                                                                .addComponent(UpdateInfo)))
                                                                .addContainerGap(586, Short.MAX_VALUE)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(59, 59, 59)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel36)
                                                                                .addComponent(IDUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel37)
                                                                                .addComponent(FirstNameUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel38)
                                                                                .addComponent(LastNameUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel39)
                                                                                .addComponent(BirthDateUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(MONTH5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(DAY5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel42)
                                                                                .addComponent(jLabel41)
                                                                                .addComponent(PhoneZoneUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel40)
                                                                                .addComponent(PhoneNumberUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel43)
                                                                                .addComponent(CountryUpdatetxt,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                10, Short.MAX_VALUE)
                                                                .addComponent(UpdateInfo)
                                                                .addGap(113, 113, 113)));

                jTabbedPane1.addTab("Update info", jPanel5);

                jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null }
                                },
                                new String[] {
                                                "ID", "Departure Date", "Arrival Date"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane1.setViewportView(jTable1);

                jButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jButton2.setText("Refresh");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(269, 269, 269)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                590,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(322, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButton2)
                                                                .addGap(527, 527, 527)));
                jPanel7Layout.setVerticalGroup(
                                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addGap(61, 61, 61)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                29, Short.MAX_VALUE)
                                                                .addComponent(jButton2)
                                                                .addContainerGap()));

                jTabbedPane1.addTab("Show my flights", jPanel7);

                jTable2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jTable2.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Name", "Birthdate", "Age", "Phone", "Country", "Num Flight"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.Long.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.Integer.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane2.setViewportView(jTable2);

                jButton3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jButton3.setText("Refresh");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGroup(jPanel8Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel8Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(489, 489, 489)
                                                                                                .addComponent(jButton3))
                                                                                .addGroup(jPanel8Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(47, 47, 47)
                                                                                                .addComponent(jScrollPane2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                1078,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(56, Short.MAX_VALUE)));
                jPanel8Layout.setVerticalGroup(
                                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(72, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton3)
                                                                .addContainerGap()));

                jTabbedPane1.addTab("Show all passengers", jPanel8);

                jTable3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jTable3.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Departure Airport ID", "Arrival Airport ID", "Scale Airport ID",
                                                "Departure Date", "Arrival Date", "Plane ID", "Number Passengers"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class, java.lang.Integer.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane3.setViewportView(jTable3);

                jButton4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jButton4.setText("Refresh");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
                jPanel9.setLayout(jPanel9Layout);
                jPanel9Layout.setHorizontalGroup(
                                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addGroup(jPanel9Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel9Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(jScrollPane3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                1100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel9Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(521, 521, 521)
                                                                                                .addComponent(jButton4)))
                                                                .addContainerGap(52, Short.MAX_VALUE)));
                jPanel9Layout.setVerticalGroup(
                                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addComponent(jScrollPane3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton4)
                                                                .addContainerGap(18, Short.MAX_VALUE)));

                jTabbedPane1.addTab("Show all flights", jPanel9);

                jButton5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jButton5.setText("Refresh");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });

                jTable4.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Brand", "Model", "Max Capacity", "Airline", "Number Flights"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane4.setViewportView(jTable4);

                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel10Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(508, 508, 508)
                                                                                                .addComponent(jButton5))
                                                                                .addGroup(jPanel10Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(145, 145, 145)
                                                                                                .addComponent(jScrollPane4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                816,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(220, Short.MAX_VALUE)));
                jPanel10Layout.setVerticalGroup(
                                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(45, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(34, 34, 34)
                                                                .addComponent(jButton5)
                                                                .addGap(17, 17, 17)));

                jTabbedPane1.addTab("Show all planes", jPanel10);

                jTable5.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Airport ID", "Airport Name", "City", "Country"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                jScrollPane5.setViewportView(jTable5);

                ShowAllLocationsRefreshBTN.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ShowAllLocationsRefreshBTN.setText("Refresh");
                ShowAllLocationsRefreshBTN.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ShowAllLocationsRefreshBTNActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                jPanel11.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(
                                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGroup(jPanel11Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel11Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(508, 508, 508)
                                                                                                .addComponent(ShowAllLocationsRefreshBTN))
                                                                                .addGroup(jPanel11Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(226, 226, 226)
                                                                                                .addComponent(jScrollPane5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                652,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(303, Short.MAX_VALUE)));
                jPanel11Layout.setVerticalGroup(
                                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(48, Short.MAX_VALUE)
                                                                .addComponent(jScrollPane5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(ShowAllLocationsRefreshBTN)
                                                                .addGap(17, 17, 17)));

                jTabbedPane1.addTab("Show all locations", jPanel11);

                ComboBoxHour.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxHour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

                jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel46.setText("Hours:");

                jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel47.setText("ID:");

                ComboBoxID.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));
                ComboBoxID.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ComboBoxIDActionPerformed(evt);
                        }
                });

                jLabel48.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel48.setText("Minutes:");

                ComboBoxMinute.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxMinute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

                jButton7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jButton7.setText("Delay");
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton7ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
                jPanel12.setLayout(jPanel12Layout);
                jPanel12Layout.setHorizontalGroup(
                                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel12Layout.createSequentialGroup()
                                                                .addGap(94, 94, 94)
                                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel12Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel48)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(ComboBoxMinute,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                109,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel12Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel12Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel47)
                                                                                                                .addComponent(jLabel46))
                                                                                                .addGap(79, 79, 79)
                                                                                                .addGroup(jPanel12Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(ComboBoxHour,
                                                                                                                                0,
                                                                                                                                136,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(ComboBoxID,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addGap(820, 820, 820))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButton7)
                                                                .addGap(531, 531, 531)));
                jPanel12Layout.setVerticalGroup(
                                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel12Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel47)
                                                                                .addComponent(ComboBoxID,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel46)
                                                                                .addComponent(ComboBoxHour,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel48)
                                                                                .addComponent(ComboBoxMinute,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                307, Short.MAX_VALUE)
                                                                .addComponent(jButton7)
                                                                .addGap(33, 33, 33)));

                jTabbedPane1.addTab("Delay flight", jPanel12);

                IDFlightAdd.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                IDFlightAdd.setEnabled(false);

                jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel44.setText("ID:");

                jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                jLabel45.setText("Flight:");

                ComboBoxFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                ComboBoxFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flight" }));
                ComboBoxFlight.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ComboBoxFlightActionPerformed(evt);
                        }
                });

                AddToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
                AddToFlight.setText("Add");
                AddToFlight.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                AddToFlightActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(64, 64, 64)
                                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel44)
                                                                                .addComponent(jLabel45))
                                                                .addGap(79, 79, 79)
                                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(ComboBoxFlight,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(IDFlightAdd,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                130,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(860, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(AddToFlight,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                120,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(509, 509, 509)));
                jPanel6Layout.setVerticalGroup(
                                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel6Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(3, 3, 3)
                                                                                                .addComponent(jLabel44))
                                                                                .addComponent(IDFlightAdd,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(35, 35, 35)
                                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel45)
                                                                                .addComponent(ComboBoxFlight,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                288, Short.MAX_VALUE)
                                                                .addComponent(AddToFlight,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(85, 85, 85)));

                jTabbedPane1.addTab("Add to flight", jPanel6);

                panelRound1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 1150, 620));

                javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
                panelRound3.setLayout(panelRound3Layout);
                panelRound3Layout.setHorizontalGroup(
                                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 1150, Short.MAX_VALUE));
                panelRound3Layout.setVerticalGroup(
                                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 36, Short.MAX_VALUE));

                panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 660, 1150, -1));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void panelRound2MousePressed(java.awt.event.MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    private void panelRound2MouseDragged(java.awt.event.MouseEvent evt) {
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String flightId = ComboBoxID.getItemAt(ComboBoxID.getSelectedIndex());
            int hours = Integer.parseInt(ComboBoxHour.getItemAt(ComboBoxHour.getSelectedIndex()));
            int minutes = Integer.parseInt(ComboBoxMinute.getItemAt(ComboBoxMinute.getSelectedIndex()));
            controller.delayFlight(flightId, hours, minutes);
            JOptionPane.showMessageDialog(this, "Vuelo retrasado correctamente.");
            limpiarCamposDelayFlight();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al retrasar el vuelo: " + e.getMessage());
        }
    }

    private void ShowAllLocationsRefreshBTNActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);

        Response<List<Location>> resp = controller.getAllLocations();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Location location : resp.getData()) {
                model.addRow(new Object[]{
                    location.getAirportId(),
                    location.getAirportName(),
                    location.getAirportCity(),
                    location.getAirportCountry()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener ubicaciones: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);

        Response<List<Plane>> resp = controller.getAllPlanes();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Plane plane : resp.getData()) {
                model.addRow(new Object[]{
                    plane.getId(),
                    plane.getBrand(),
                    plane.getModel(),
                    plane.getMaxCapacity(),
                    plane.getAirline(),
                    plane.getNumFlights()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener aviones: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

        Response<List<Flight>> resp = controller.getAllFlights();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Flight flight : resp.getData()) {
                model.addRow(new Object[]{
                    flight.getId(),
                    flight.getDepartureLocation().getAirportId(),
                    flight.getArrivalLocation().getAirportId(),
                    (flight.getScaleLocation() == null ? "-" : flight.getScaleLocation().getAirportId()),
                    flight.getDepartureDate(),
                    flight.calculateArrivalDate(),
                    flight.getPlane().getId(),
                    flight.getNumPassengers()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener vuelos: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        Response<List<Passenger>> resp = controller.getAllPassengers();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Passenger passenger : resp.getData()) {
                model.addRow(new Object[]{
                    passenger.getId(),
                    passenger.getFullname(),
                    passenger.getBirthDate(),
                    passenger.calculateAge(),
                    passenger.generateFullPhone(),
                    passenger.getCountry(),
                    passenger.getNumFlights()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al obtener pasajeros: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            long passengerId = Long.parseLong(userSelect.getItemAt(userSelect.getSelectedIndex()));
            Response<List<Flight>> resp = controller.getFlightsByPassenger(passengerId);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
                for (Flight flight : resp.getData()) {
                    model.addRow(new Object[]{
                        flight.getId(),
                        flight.getDepartureDate(),
                        flight.calculateArrivalDate()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener vuelos del pasajero: "
                        + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar vuelos: " + e.getMessage());
        }
    }

    private void AddToFlightActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            long passengerId = Long.parseLong(IDFlightAdd.getText());
            String flightId = ComboBoxFlight.getItemAt(ComboBoxFlight.getSelectedIndex());
            controller.addPassengerToFlight(passengerId, flightId);
            JOptionPane.showMessageDialog(this, "Pasajero agregado al vuelo correctamente.");
            limpiarCamposAgregarPasajeroVuelo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar pasajero al vuelo: " + e.getMessage());
        }
    }

    private void UpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            long id = Long.parseLong(IDUpdatetxt.getText());
            String firstname = FirstNameUpdatetxt.getText();
            String lastname = LastNameUpdatetxt.getText();
            int year = Integer.parseInt(BirthDateUpdatetxt.getText());
            int month = Integer.parseInt(MONTH.getItemAt(MONTH5.getSelectedIndex()));
            int day = Integer.parseInt(DAY.getItemAt(DAY5.getSelectedIndex()));
            int phoneCode = Integer.parseInt(PhoneZoneUpdatetxt.getText());
            long phone = Long.parseLong(PhoneNumberUpdatetxt.getText());
            String country = CountryUpdatetxt.getText();
            controller.updatePassenger(id, firstname, lastname, year, month, day, phoneCode, phone, country);
            JOptionPane.showMessageDialog(this, "Información actualizada correctamente.");
            limpiarCamposUpdatePasajero();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar información: " + e.getMessage());
        }
    }

    private void CreateFlightActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = IDflight.getText().trim();
            String planeId = ComboBoxPlane.getItemAt(ComboBoxPlane.getSelectedIndex());
            String departureLocationId = ComboBoxLocation1.getItemAt(ComboBoxLocation1.getSelectedIndex());
            String arrivalLocationId = ComboBoxLocation2.getItemAt(ComboBoxLocation2.getSelectedIndex());
            String scaleLocationId = ComboBoxLocation3.getItemAt(ComboBoxLocation3.getSelectedIndex());

            if (scaleLocationId == null
                    || scaleLocationId.isEmpty()
                    || scaleLocationId.equals("-")
                    || scaleLocationId.equals("Seleccione una ubicación")) {
                scaleLocationId = null;
            }

            int year = parseComboValue(DepartureDatetxt.getText(), "Año");
            int month = parseComboValue(MONTH1.getItemAt(MONTH1.getSelectedIndex()), "Mes");
            int day = parseComboValue(DAY1.getItemAt(DAY1.getSelectedIndex()), "Día");
            int hour = parseComboValue(MONTH2.getItemAt(MONTH2.getSelectedIndex()), "Hora");
            int minutes = parseComboValue(DAY2.getItemAt(DAY2.getSelectedIndex()), "Minutos");
            int hoursDurationsArrival = parseComboValue(MONTH3.getItemAt(MONTH3.getSelectedIndex()), "Horas de llegada");
            int minutesDurationsArrival = parseComboValue(DAY3.getItemAt(DAY3.getSelectedIndex()), "Minutos de llegada");

            int hoursDurationsScale = 0;
            int minutesDurationsScale = 0;
            if (scaleLocationId != null) {
                String hoursScaleStr = MONTH4.getItemAt(MONTH4.getSelectedIndex());
                String minutesScaleStr = DAY4.getItemAt(DAY4.getSelectedIndex());

                if (!isNumeric(hoursScaleStr)) {
                    JOptionPane.showMessageDialog(this, "Selecciona una hora válida para 'Horas de escala'.");
                    return;
                }
                if (!isNumeric(minutesScaleStr)) {
                    JOptionPane.showMessageDialog(this, "Selecciona un valor válido para 'Minutos de escala'.");
                    return;
                }
                hoursDurationsScale = Integer.parseInt(hoursScaleStr);
                minutesDurationsScale = Integer.parseInt(minutesScaleStr);
            }

            controller.createFlight(
                    id, planeId, departureLocationId, arrivalLocationId, scaleLocationId,
                    year, month, day, hour, minutes,
                    hoursDurationsArrival, minutesDurationsArrival,
                    hoursDurationsScale, minutesDurationsScale);

            ComboBoxFlight.addItem(id);
            cargarComboBoxFlights();
            JOptionPane.showMessageDialog(this, "Vuelo creado correctamente.");
            limpiarCamposRegistroVuelo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear vuelo: " + e.getMessage());
        }
    }

    private int parseComboValue(String value, String fieldName) throws NumberFormatException {
        if (!isNumeric(value)) {
            throw new NumberFormatException("El campo '" + fieldName + "' no contiene un número válido: '" + value + "'");
        }
        return Integer.parseInt(value);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void CreateLocationActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = AirportIDtxt.getText();
            String name = AirportNametxt.getText();
            String city = AirportCitytxt.getText();
            String country = AirportCountrytxt.getText();
            double latitude = Double.parseDouble(AirportLatitudetxt.getText());
            double longitude = Double.parseDouble(AirportLongitudetxt.getText());
            controller.createLocation(id, name, city, country, latitude, longitude);
            ComboBoxLocation1.addItem(id);
            ComboBoxLocation2.addItem(id);
            ComboBoxLocation3.addItem(id);
            cargarComboBoxLocations(ComboBoxLocation1);
            cargarComboBoxLocations(ComboBoxLocation2);
            cargarComboBoxLocations(ComboBoxLocation3);
            JOptionPane.showMessageDialog(this, "Ubicación creada correctamente.");
            limpiarCamposRegistroUbicacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear ubicación: " + e.getMessage());
        }
    }

    private void CreateAirplaneActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = IDPlanetxt.getText();
            String brand = Brandtxt.getText();
            String model = Modeltxt.getText();
            int maxCapacity = Integer.parseInt(MaxCapacitytxt.getText());
            String airline = Airlinetxt.getText();
            controller.createPlane(id, brand, model, maxCapacity, airline);
            ComboBoxPlane.addItem(id);
            cargarComboBoxPlanes();
            JOptionPane.showMessageDialog(this, "Avión creado correctamente.");
            limpiarCamposRegistroAvion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear avión: " + e.getMessage());
        }
    }

    private void RegisterPassengerActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            long id = Long.parseLong(IDPassengertxt.getText());
            String firstname = FirstNametxt.getText();
            String lastname = LastNametxt.getText();
            int year = Integer.parseInt(BirthDatetxt.getText());
            int month = Integer.parseInt(MONTH.getItemAt(MONTH.getSelectedIndex()));
            int day = Integer.parseInt(DAY.getItemAt(DAY.getSelectedIndex()));
            int phoneCode = Integer.parseInt(PhoneZonetxt.getText());
            long phone = Long.parseLong(PhoneNumbertxt.getText());
            String country = Countrytxt.getText();
            controller.registerPassenger(id, firstname, lastname, year, month, day, phoneCode, phone, country);
            userSelect.addItem("" + id);
            cargarComboBoxPasajeros();
            JOptionPane.showMessageDialog(this, "Pasajero registrado correctamente.");
            limpiarCamposRegistroPasajero();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar pasajero: " + e.getMessage());
        }
    }

    private void userSelectActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = userSelect.getSelectedItem().toString();
            if (!id.equals(userSelect.getItemAt(0))) {
                IDUpdatetxt.setText(id);
                IDFlightAdd.setText(id);
            } else {
                IDUpdatetxt.setText("");
                IDFlightAdd.setText("");
            }
        } catch (Exception e) {
        }
    }

    private void administratorActionPerformed(java.awt.event.ActionEvent evt) {
        if (user.isSelected()) {
            user.setSelected(false);
            userSelect.setSelectedIndex(0);
        }
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setEnabledAt(i, true);
        }
        jTabbedPane1.setEnabledAt(5, false);
        jTabbedPane1.setEnabledAt(6, false);
    }

    private void userActionPerformed(java.awt.event.ActionEvent evt) {
        if (administrator.isSelected()) {
            administrator.setSelected(false);
        }
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setEnabledAt(i, false);
        }
        jTabbedPane1.setEnabledAt(9, true);
        jTabbedPane1.setEnabledAt(5, true);
        jTabbedPane1.setEnabledAt(6, true);
        jTabbedPane1.setEnabledAt(7, true);
        jTabbedPane1.setEnabledAt(11, true);
    }

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
//Realizar el cargar automatico.
    private void cargarComboBoxFlights() {
        ComboBoxFlight.removeAllItems();
        ComboBoxID.removeAllItems();
        ComboBoxFlight.addItem("Seleccione un vuelo");

        Response<List<Flight>> resp = controller.getAllFlights();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Flight f : resp.getData()) {
                ComboBoxFlight.addItem(String.valueOf(f.getId()));
                ComboBoxID.addItem(String.valueOf(f.getId()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar vuelos: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void ComboBoxFlightActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = ComboBoxFlight.getSelectedItem().toString();
            if (!id.equals(ComboBoxFlight.getItemAt(0))) {
            } else {
            }
        } catch (Exception e) {
        }
    }
    
//Realizar el cargar automatico.
    private void cargarComboBoxPlanes() {
        ComboBoxPlane.removeAllItems();
        ComboBoxPlane.addItem("Seleccione un avión");

        Response<List<Plane>> resp = controller.getAllPlanes();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Plane p : resp.getData()) {
                ComboBoxPlane.addItem(String.valueOf(p.getId()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar aviones: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void ComboBoxPlaneActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = ComboBoxPlane.getSelectedItem().toString();
            if (!id.equals(ComboBoxPlane.getItemAt(0))) {
                // lógica de selección válida
            } else {
                // lógica de limpiar campos relacionados
            }
        } catch (Exception e) {
            // Manejo opcional
        }
    }

    private void cargarComboBoxLocations(JComboBox comboBox) {
        comboBox.removeAllItems();
        comboBox.addItem("Seleccione una ubicación");

        Response<List<Location>> resp = controller.getAllLocations();
        if (resp != null && resp.getStatus() == 200 && resp.getData() != null) {
            for (Location l : resp.getData()) {
                comboBox.addItem(l.getAirportId());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar ubicaciones: "
                    + (resp != null ? resp.getMessage() : "Respuesta nula del controlador."));
        }
    }

    private void ComboBoxLocation1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = ComboBoxLocation1.getSelectedItem().toString();
            if (!id.equals(ComboBoxLocation1.getItemAt(0))) {
                // lógica selección válida
            } else {
                // lógica limpiar campos relacionados
            }
        } catch (Exception e) {
            // Manejo opcional
        }
    }

    private void ComboBoxLocation2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = ComboBoxLocation2.getSelectedItem().toString();
            if (!id.equals(ComboBoxLocation2.getItemAt(0))) {
                // lógica selección válida
            } else {
                // lógica limpiar campos relacionados
            }
        } catch (Exception e) {
            // Manejo opcional
        }
    }

    private void ComboBoxLocation3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = ComboBoxLocation3.getSelectedItem().toString();
            if (!id.equals(ComboBoxLocation3.getItemAt(0))) {
                // lógica selección válida
            } else {
                // lógica limpiar campos relacionados
            }
        } catch (Exception e) {
            // Manejo opcional
        }
    }

    private void ComboBoxIDActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = ComboBoxID.getSelectedItem().toString();
            if (!id.equals(ComboBoxID.getItemAt(0))) {
                // lógica selección válida
            } else {
                // lógica limpiar campos relacionados
            }
        } catch (Exception e) {
            // Manejo opcional
        }
    }

// ---------------------- METODOS DE LIMPIEZA DE CAMPOS ----------------------
    private void limpiarCamposRegistroPasajero() {
        IDPassengertxt.setText("");
        FirstNametxt.setText("");
        LastNametxt.setText("");
        BirthDatetxt.setText("");
        PhoneZonetxt.setText("");
        PhoneNumbertxt.setText("");
        Countrytxt.setText("");
        MONTH.setSelectedIndex(0);
        DAY.setSelectedIndex(0);
    }

    private void limpiarCamposUpdatePasajero() {
        IDUpdatetxt.setText("");
        FirstNameUpdatetxt.setText("");
        LastNameUpdatetxt.setText("");
        BirthDateUpdatetxt.setText("");
        PhoneZoneUpdatetxt.setText("");
        PhoneNumberUpdatetxt.setText("");
        CountryUpdatetxt.setText("");
        MONTH5.setSelectedIndex(0);
        DAY5.setSelectedIndex(0);
    }

    private void limpiarCamposRegistroAvion() {
        IDPlanetxt.setText("");
        Brandtxt.setText("");
        Modeltxt.setText("");
        MaxCapacitytxt.setText("");
        Airlinetxt.setText("");
    }

    private void limpiarCamposRegistroUbicacion() {
        AirportIDtxt.setText("");
        AirportNametxt.setText("");
        AirportCitytxt.setText("");
        AirportCountrytxt.setText("");
        AirportLatitudetxt.setText("");
        AirportLongitudetxt.setText("");
    }

    private void limpiarCamposRegistroVuelo() {
        IDflight.setText("");
        DepartureDatetxt.setText("");
        ComboBoxPlane.setSelectedIndex(0);
        ComboBoxLocation1.setSelectedIndex(0);
        ComboBoxLocation2.setSelectedIndex(0);
        ComboBoxLocation3.setSelectedIndex(0);
        MONTH1.setSelectedIndex(0);
        DAY1.setSelectedIndex(0);
        MONTH2.setSelectedIndex(0);
        DAY2.setSelectedIndex(0);
        MONTH3.setSelectedIndex(0);
        DAY3.setSelectedIndex(0);
        MONTH4.setSelectedIndex(0);
        DAY4.setSelectedIndex(0);
    }

    private void limpiarCamposAgregarPasajeroVuelo() {
        IDFlightAdd.setText("");
        ComboBoxFlight.setSelectedIndex(0);
    }

    private void limpiarCamposDelayFlight() {
        ComboBoxID.setSelectedIndex(0);
        ComboBoxHour.setSelectedIndex(0);
        ComboBoxMinute.setSelectedIndex(0);
    }


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton AddToFlight;
        private javax.swing.JTextField Airlinetxt;
        private javax.swing.JTextField AirportCitytxt;
        private javax.swing.JTextField AirportCountrytxt;
        private javax.swing.JTextField AirportIDtxt;
        private javax.swing.JTextField AirportLatitudetxt;
        private javax.swing.JTextField AirportLongitudetxt;
        private javax.swing.JTextField AirportNametxt;
        private javax.swing.JTextField BirthDateUpdatetxt;
        private javax.swing.JTextField BirthDatetxt;
        private javax.swing.JTextField Brandtxt;
        private javax.swing.JComboBox<String> ComboBoxFlight;
        private javax.swing.JComboBox<String> ComboBoxHour;
        private javax.swing.JComboBox<String> ComboBoxID;
        private javax.swing.JComboBox<String> ComboBoxLocation1;
        private javax.swing.JComboBox<String> ComboBoxLocation2;
        private javax.swing.JComboBox<String> ComboBoxLocation3;
        private javax.swing.JComboBox<String> ComboBoxMinute;
        private javax.swing.JComboBox<String> ComboBoxPlane;
        private javax.swing.JTextField CountryUpdatetxt;
        private javax.swing.JTextField Countrytxt;
        private javax.swing.JButton CreateAirplane;
        private javax.swing.JButton CreateFlight;
        private javax.swing.JButton CreateLocation;
        private javax.swing.JComboBox<String> DAY;
        private javax.swing.JComboBox<String> DAY1;
        private javax.swing.JComboBox<String> DAY2;
        private javax.swing.JComboBox<String> DAY3;
        private javax.swing.JComboBox<String> DAY4;
        private javax.swing.JComboBox<String> DAY5;
        private javax.swing.JTextField DepartureDatetxt;
        private javax.swing.JTextField FirstNameUpdatetxt;
        private javax.swing.JTextField FirstNametxt;
        private javax.swing.JTextField IDFlightAdd;
        private javax.swing.JTextField IDPassengertxt;
        private javax.swing.JTextField IDPlanetxt;
        private javax.swing.JTextField IDUpdatetxt;
        private javax.swing.JTextField IDflight;
        private javax.swing.JTextField LastNameUpdatetxt;
        private javax.swing.JTextField LastNametxt;
        private javax.swing.JComboBox<String> MONTH;
        private javax.swing.JComboBox<String> MONTH1;
        private javax.swing.JComboBox<String> MONTH2;
        private javax.swing.JComboBox<String> MONTH3;
        private javax.swing.JComboBox<String> MONTH4;
        private javax.swing.JComboBox<String> MONTH5;
        private javax.swing.JTextField MaxCapacitytxt;
        private javax.swing.JTextField Modeltxt;
        private javax.swing.JTextField PhoneNumberUpdatetxt;
        private javax.swing.JTextField PhoneNumbertxt;
        private javax.swing.JTextField PhoneZoneUpdatetxt;
        private javax.swing.JTextField PhoneZonetxt;
        private javax.swing.JButton RegisterPassenger;
        private javax.swing.JButton ShowAllLocationsRefreshBTN;
        private javax.swing.JButton UpdateInfo;
        private javax.swing.JRadioButton administrator;
        private javax.swing.JButton jButton13;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton7;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel19;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel22;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JLabel jLabel24;
        private javax.swing.JLabel jLabel25;
        private javax.swing.JLabel jLabel26;
        private javax.swing.JLabel jLabel27;
        private javax.swing.JLabel jLabel28;
        private javax.swing.JLabel jLabel29;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel30;
        private javax.swing.JLabel jLabel31;
        private javax.swing.JLabel jLabel32;
        private javax.swing.JLabel jLabel33;
        private javax.swing.JLabel jLabel34;
        private javax.swing.JLabel jLabel35;
        private javax.swing.JLabel jLabel36;
        private javax.swing.JLabel jLabel37;
        private javax.swing.JLabel jLabel38;
        private javax.swing.JLabel jLabel39;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel40;
        private javax.swing.JLabel jLabel41;
        private javax.swing.JLabel jLabel42;
        private javax.swing.JLabel jLabel43;
        private javax.swing.JLabel jLabel44;
        private javax.swing.JLabel jLabel45;
        private javax.swing.JLabel jLabel46;
        private javax.swing.JLabel jLabel47;
        private javax.swing.JLabel jLabel48;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel12;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTable jTable2;
        private javax.swing.JTable jTable3;
        private javax.swing.JTable jTable4;
        private javax.swing.JTable jTable5;
        private airport.view.PanelRound panelRound1;
        private airport.view.PanelRound panelRound2;
        private airport.view.PanelRound panelRound3;
        private javax.swing.JRadioButton user;
        private javax.swing.JComboBox<String> userSelect;
        // End of variables declaration//GEN-END:variables
}
