package FWD;

import FWD.model.FileOperation;
import FWD.view.InvoiceHeader;
import FWD.view.InvoiceLine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// author: Andrew EMil
public class InvoiceFrame extends javax.swing.JFrame implements ActionListener, ListSelectionListener  {

    
    public InvoiceFrame() {
        initComponents();
    }



  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(this);
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(this);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(this);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custNameTF = new javax.swing.JTextField();
        invDateTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLineTable = new javax.swing.JTable();
        createLineBtn = new javax.swing.JButton();
        createLineBtn.addActionListener(this);
        deleteLineBtn = new javax.swing.JButton();
        deleteLineBtn.addActionListener(this);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(this);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoicesTable);
        invoicesTable.getAccessibleContext().setAccessibleName("");

        createInvBtn.setText("Create New Invoice");
        createInvBtn.setActionCommand("CreateNewInvoice");
        createInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvBtnActionPerformed(evt);
            }
        });

        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.setActionCommand("DeleteInvoice");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        custNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameTFActionPerformed(evt);
            }
        });

        invDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invDateTFActionPerformed(evt);
            }
        });

        invLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invLineTable);

        createLineBtn.setText("Create New Line");
        createLineBtn.setActionCommand("CreateNewLine");
        createLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLineBtnActionPerformed(evt);
            }
        });

        deleteLineBtn.setActionCommand("DeleteLine");
        deleteLineBtn.setLabel("Delete Line");
        deleteLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(createInvBtn)
                        .addGap(68, 68, 68)
                        .addComponent(deleteInvBtn)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(invTotalLbl))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invDateTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(custNameTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(createLineBtn)
                        .addGap(98, 98, 98)
                        .addComponent(deleteLineBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(custNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLbl))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createLineBtn)
                            .addComponent(deleteLineBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createInvBtn)
                    .addComponent(deleteInvBtn))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameTFActionPerformed
       
    }//GEN-LAST:event_custNameTFActionPerformed

    private void createLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLineBtnActionPerformed
       
    }//GEN-LAST:event_createLineBtnActionPerformed

    private void deleteLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLineBtnActionPerformed
      
    }//GEN-LAST:event_deleteLineBtnActionPerformed

    private void invDateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invDateTFActionPerformed
        
    }//GEN-LAST:event_invDateTFActionPerformed

    private void createInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvBtnActionPerformed
       
    }//GEN-LAST:event_createInvBtnActionPerformed

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvBtnActionPerformed
        
    }//GEN-LAST:event_deleteInvBtnActionPerformed

   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createLineBtn;
    private javax.swing.JTextField custNameTF;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteLineBtn;
    private javax.swing.JTextField invDateTF;
    private javax.swing.JTable invLineTable;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
private DateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");
private List<FileOperation> invoicesArray = new ArrayList<>();
private FileOperation.invoiceHTable invoiceHTable;
private FileOperation.invoiceLTable invoiceLTable;
private InvoiceHeader headerDialog;
private InvoiceLine lineDialog;
    @Override
    public void actionPerformed(ActionEvent e) {
switch (e.getActionCommand()){
case "CreateNewInvoice":
    
    displayNewInvoiceDialog();
    break;
case "DeleteInvoice":
     deleteInvoice();
    break;
case "CreateNewLine":
    displayNewLineDialog();
    break;
    
case "DeleteLine":
    deleteLineBtn();
    break;
 case "LoadFile":
     LoadFile();
     break;
 case "SaveFile":
     savedata();
   break;
 case "createInvCancel":
     createInvCancel();
     break;
     case "createInvOK":
         createInvOK();
     break;
     case "createLineCancel":
         createLineCancel();
         break;
     case "createLineOK":
         createLineOK();
         break;

}
    }
       
    private void LoadFile() {
        JOptionPane.showMessageDialog(this, "Please, select header file!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try{
            FileReader headerFr = new FileReader(headerFile);
            BufferedReader headerBr = new BufferedReader (headerFr);
            String headerLine = null;
            
            while (( headerLine = headerBr.readLine()) != null) {
            String[] headerParts = headerLine.split(",");
            String invNumS = headerParts[0];
            String invDateStr = headerParts[1];
            String custName = headerParts[2];
 
            int invNum = Integer.parseInt(invNumS);
            Date invDate = dateF.parse(invDateStr);
            
            FileOperation inv = new FileOperation(invNum, custName, invDate);
            invoicesArray.add(inv);
            
            }
            
            JOptionPane.showMessageDialog(this, "Please, select the line csv file !", "Attention", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr= new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) !=null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumS = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];
                 int invNum = Integer.parseInt(invNumS);
   double itemPrice = Double.parseDouble(itemPriceStr);
   int itemCount = Integer.parseInt(itemCountStr);
   FileOperation header = findInvoiceByNum(invNum);
   FileOperation.InvoiceLine invLine = new FileOperation.InvoiceLine(  itemName, itemPrice, itemCount, header);
                  header.getLines().add(invLine);
                    }
 invoiceHTable = new FileOperation.invoiceHTable(invoicesArray);
 invoicesTable.setModel(invoiceHTable);
 invoicesTable.validate();

                }
                
            } catch (Exception ex){
                ex.printStackTrace();
            }
                     
        }

     displayInvoices();
    }

    private void savedata() {
String headers = "";
        String lines = "";
        for (FileOperation header : invoicesArray) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (FileOperation.InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(this, "Please select the header file to save data!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter hFW = new FileWriter(headerFile);
                hFW.write(headers);
                hFW.flush();
                hFW.close();

                JOptionPane.showMessageDialog(this, "Please select the line file to save data!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter lFW = new FileWriter(linesFile);
                    lFW.write(lines);
                    lFW.flush();
                    lFW.close();
                }
                                           JOptionPane.showMessageDialog(null, "File Saved ! ");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
private FileOperation findInvoiceByNum(int invNum){
    FileOperation header = null;
    for(FileOperation inv : invoicesArray) {
        if (invNum == inv.getInvNum()){
            header = inv;
            break;
        }
    }
    return header ;
}

    @Override
    public void valueChanged(ListSelectionEvent e) {
invoicesTableRowSelected();
    }

    private void invoicesTableRowSelected() {
int selectedRowIndex = invoicesTable.getSelectedRow();
if (selectedRowIndex >= 0){
    FileOperation row = invoiceHTable.getInvoicesArray().get(selectedRowIndex);
    custNameTF.setText(row.getCustomerName());
    invDateTF.setText(dateF.format(row.getInvDate()));
    jLabel1.setText("" + row.getInvNum());
    invTotalLbl.setText("" + row.getInvTotal());
    ArrayList<FileOperation.InvoiceLine> lines = row.getLines();
    invoiceLTable = new FileOperation.invoiceLTable(lines);
    invLineTable.setModel(invoiceLTable);
    invoiceLTable.fireTableDataChanged();
    
}
    }
 private void deleteInvoice() {
        int invIndex = invoicesTable.getSelectedRow();
        FileOperation header = invoiceHTable.getInvoicesArray().get(invIndex);
        invoiceHTable.getInvoicesArray().remove(invIndex);
        invoiceHTable.fireTableDataChanged();
        invoiceLTable = new FileOperation.invoiceLTable(new ArrayList<FileOperation.InvoiceLine>());
        invLineTable.setModel(invoiceLTable);
        invoiceLTable.fireTableDataChanged();
        custNameTF.setText("");
        invDateTF.setText("");
        jLabel3.setText("");
        invTotalLbl.setText("");
        displayInvoices();
             JOptionPane.showMessageDialog(null, "Invoice Deleted ! ");
 

     }  

   
    private void deleteLineBtn() {
       
           
        int lineIndex = invLineTable.getSelectedRow();
        FileOperation.InvoiceLine line = invoiceLTable.getInvoiceLines().get(lineIndex);
           invoiceLTable.getInvoiceLines().remove(lineIndex);
            invoiceHTable.fireTableDataChanged();
        invoiceLTable.fireTableDataChanged();
                invTotalLbl.setText("" + line.getHeader().getInvTotal());
         JOptionPane.showMessageDialog(null, "Line Deleted ! ");
          displayInvoices();
        }      
      
       
       
     
     private void displayInvoices(){
         for (FileOperation header :invoicesArray) {
             System.out.println(header);
         }
     }
private void displayNewInvoiceDialog() {
headerDialog  = new InvoiceHeader(this);
headerDialog.setVisible(true);
       
    }
  private void displayNewLineDialog() {
lineDialog = new InvoiceLine(this);
lineDialog.setVisible(true);

    }
    
    private void createInvCancel() {
headerDialog.setVisible(false);
headerDialog.dispose();
headerDialog = null;
    }

    private void createInvOK() {
String CN = headerDialog.getCustNameField().getText();
String invDateStr = headerDialog.getInvDateField().getText();
headerDialog.setVisible(false);
headerDialog.dispose();
headerDialog = null;
try {
    Date invDate = dateF.parse(invDateStr);
    int invNum = getNextInvoiceNum();
    FileOperation fileOperation = new FileOperation(invNum, CN, invDate);
    invoicesArray.add(fileOperation);
    invoiceHTable.fireTableDataChanged();
} catch(ParseException ex) {
  ex.printStackTrace();
  displayInvoices();
}
    }
    
    private int getNextInvoiceNum() {
        int max = 0;
        for(FileOperation header : invoicesArray) {
            if (header.getInvNum()> max) {
                max = header.getInvNum();
                
            }
        }
        return max + 1;
    }

    private void createLineCancel() {
lineDialog.setVisible(false);
lineDialog.dispose();
lineDialog = null;
    }

    private void createLineOK() {
String itemName = lineDialog.getItemNameField().getText();
String itemCountStr = lineDialog.getItemCountField().getText();
String itemPriceStr = lineDialog.getItemPriceField().getText();
lineDialog.setVisible(false);
lineDialog.dispose();
lineDialog = null;
int itemCount = Integer.parseInt(itemCountStr);
double itemPrice = Double.parseDouble(itemPriceStr);
 int headerIndex = invoicesTable.getSelectedRow();
        FileOperation invoice = invoiceHTable.getInvoicesArray().get(headerIndex);
        FileOperation.InvoiceLine invoiceLine = new FileOperation.InvoiceLine( itemName, itemPrice, itemCount, invoice);
    invoice.addInvLine(invoiceLine);
        invoiceLTable.fireTableDataChanged();
        invoiceHTable.fireTableDataChanged();
        invTotalLbl.setText("" + invoice.getInvTotal());
      displayInvoices();   
    }

  
    
}