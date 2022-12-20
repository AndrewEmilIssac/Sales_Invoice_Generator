/**
 * Author : Andrew EMil
 */
package FWD.controller;

import FWD.model.FileOperation;
import FWD.view.MainInvoiceFrame;
import FWD.view.InvoiceHeader;
import FWD.view.InvoiceLine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


    public class Listner implements ActionListener, ListSelectionListener {

 private MainInvoiceFrame frame;
    private DateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");
    
    public Listner(MainInvoiceFrame frame) {
        this.frame = frame;
    }
 @Override
    public void actionPerformed(ActionEvent e) {
switch (e.getActionCommand()){
case "CreateNewInvoice":
    
    displayNewInvoiceDialog();
    break;
case "DeleteInvoice":
     deleteInvoice();
    break;
    case "LoadFile":
  LoadFile();
  break;
  case "SaveFile":
 savedata();
case "CreateNewLine":
    displayNewLineDialog();
 break;
    
case "DeleteLine":
    deleteLineBtn();
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
        JOptionPane.showMessageDialog(frame, "Please, select header file!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try{
            FileReader headerFr = new FileReader(headerFile);
            BufferedReader headerBr = new BufferedReader (headerFr);
            String headerLine = null;
            
            while (( headerLine = headerBr.readLine()) != null) {
            String[] headerParts = headerLine.split(",");
            String invNumS = headerParts[0];
            String invDateS = headerParts[1];
            String CN = headerParts[2];
 
            int invNum = Integer.parseInt(invNumS);
            Date invDate = dateF.parse(invDateS);
            
            FileOperation inv = new FileOperation(invNum, CN, invDate);
            frame.getInvoicesArray().add(inv);
            
            }
            
            JOptionPane.showMessageDialog(frame, "Please, select lines file!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr= new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) !=null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];
                 int invNum = Integer.parseInt(invNumStr);
   double itemPrice = Double.parseDouble(itemPriceStr);
   int itemCount = Integer.parseInt(itemCountStr);
   FileOperation header = findInvoiceByNum(invNum);
   FileOperation.InvoiceLine invLine = new FileOperation.InvoiceLine(itemName, itemPrice, itemCount, header);
                  header.getLines().add(invLine);
                    }
 frame.setInvoiceHTable(new FileOperation.invoiceHTable(frame.getInvoicesArray()));
 frame.getInvoicesTable().setModel(frame.getInvoiceHTable());
 frame.getInvoicesTable().validate();

                }
                 System.out.println("Check");
            } catch (ParseException ex) {
                ex.printStackTrace();
               JOptionPane.showMessageDialog(frame, "Date Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Number Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "File Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Read Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        displayInvoices();
    }  


   
         
        
      private FileOperation findInvoiceByNum(int invNum){
    FileOperation header = null;
    for(FileOperation inv : frame.getInvoicesArray()) {
        if (invNum == inv.getInvNum()){
            header = inv;
            break;
        }
    }
    return header ;
}                 
    private void savedata() {
String headers = "";
        String lines = "";
        for (FileOperation header : frame.getInvoicesArray()) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (FileOperation.InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Please, select file to save header data!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter hFW = new FileWriter(headerFile);
                hFW.write(headers);
                hFW.flush();
                hFW.close();

                JOptionPane.showMessageDialog(frame, "Please, select file to save lines data!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter lFW = new FileWriter(linesFile);
                    lFW.write(lines);
                    lFW.flush();
                    lFW.close();
                }
                                           JOptionPane.showMessageDialog(null, "File Saved ! ");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
   

    @Override
    public void valueChanged(ListSelectionEvent e) {
    System.out.println("Invoice Selected!");
invoicesTableRowSelected();
    }

    private void invoicesTableRowSelected() {
int selectedRowIndex = frame.getInvoicesTable().getSelectedRow();
if (selectedRowIndex >= 0){
    FileOperation row = frame.getInvoiceHTable().getInvoicesArray().get(selectedRowIndex);
    frame.getCustNameTF().setText(row.getCustomerName());
    frame.getInvDateTF().setText(dateF.format(row.getInvDate()));
    frame.getInvNumLbl().setText("" + row.getInvNum());
    frame.getInvTotalLbl().setText("" + row.getInvTotal());
    ArrayList<FileOperation.InvoiceLine> lines = row.getLines();
    frame.setInvoiceLTable(new FileOperation.invoiceLTable(lines));
    frame.getInvLineTable().setModel(frame.getInvoiceLTable());
    frame.getInvoiceLTable().fireTableDataChanged();
    
}
    }
 private void deleteInvoice() {
        int invIndex = frame.getInvoicesTable().getSelectedRow();
        FileOperation header = frame.getInvoiceHTable().getInvoicesArray().get(invIndex);
        frame.getInvoiceHTable().getInvoicesArray().remove(invIndex);
       frame.getInvoiceHTable().fireTableDataChanged();
        frame.setInvoiceLTable(new FileOperation.invoiceLTable(new ArrayList<FileOperation.InvoiceLine>()));
        frame.getInvLineTable().setModel(frame.getInvoiceLTable());
        frame.getInvoiceLTable().fireTableDataChanged();
        frame.getCustNameTF().setText("");
        frame.getInvDateTF().setText("");
        frame.getInvNumLbl().setText("");
        frame.getInvTotalLbl().setText("");
        displayInvoices();
             JOptionPane.showMessageDialog(null, "Invoice Deleted ! ");
 

     }  

   
    private void deleteLineBtn() {
       
           
        int lineIndex = frame.getInvLineTable().getSelectedRow();
        FileOperation.InvoiceLine line = frame.getInvoiceLTable().getInvoiceLines().get(lineIndex);
           frame.getInvoiceLTable().getInvoiceLines().remove(lineIndex);
            frame.getInvoiceHTable().fireTableDataChanged();
        frame.getInvoiceLTable().fireTableDataChanged();
                frame.getInvTotalLbl().setText("" + line.getHeader().getInvTotal());
         JOptionPane.showMessageDialog(null, "Line Deleted ! ");
          displayInvoices();
        }      
      
    
     
     private void displayInvoices(){
         for (FileOperation header :frame.getInvoicesArray()) {
             System.out.println(header);
         }
     }
      
private void displayNewInvoiceDialog() {
frame.setHeaderDialog(new InvoiceHeader(frame));
frame.getHeaderDialog().setVisible(true);
       
    }
  private void displayNewLineDialog() {
frame.setLineDialog(new InvoiceLine(frame));
frame.getLineDialog().setVisible(true);

    }
    
    private void createInvCancel() {
frame.getHeaderDialog().setVisible(false);
frame.getHeaderDialog().dispose();
frame.setHeaderDialog(null);
    }

    private void createInvOK() {
String CN = frame.getHeaderDialog().getCustNameField().getText();
String invDateStr = frame.getHeaderDialog().getInvDateField().getText();
frame.getHeaderDialog().setVisible(false);
frame.getHeaderDialog().dispose();
frame.setHeaderDialog(null);
try {
    Date invDate = dateF.parse(invDateStr);
    int invNum = getNextInvoiceNum();
    FileOperation fileOperation = new FileOperation(invNum, CN, invDate);
    frame.getInvoicesArray().add(fileOperation);
    frame.getInvoiceHTable().fireTableDataChanged();}
    catch (ParseException ex) {
    JOptionPane.showMessageDialog(frame , "Wrong date Format, please adjust it " , "Error" , JOptionPane.ERROR_MESSAGE);
  ex.printStackTrace();
  displayInvoices();
}
    }
    
    private int getNextInvoiceNum() {
        int max = 0;
        for(FileOperation header : frame.getInvoicesArray()) {
            if (header.getInvNum()> max) {
                max = header.getInvNum();
                
            }
        }
        return max + 1;
    }

    private void createLineCancel() {
frame.getLineDialog().setVisible(false);
frame.getLineDialog().dispose();
frame.setLineDialog(null);
    }

    private void createLineOK() {
String itemName = frame.getLineDialog().getItemNameField().getText();
String itemCountStr = frame.getLineDialog().getItemCountField().getText();
String itemPriceStr = frame.getLineDialog().getItemPriceField().getText();
frame.getLineDialog().setVisible(false);
frame.getLineDialog().dispose();
frame.setLineDialog(null);
int itemCount = Integer.parseInt(itemCountStr);
double itemPrice = Double.parseDouble(itemPriceStr);
 int headerIndex = frame.getInvoicesTable().getSelectedRow();
        FileOperation invoice = frame.getInvoiceHTable().getInvoicesArray().get(headerIndex);
        FileOperation.InvoiceLine invoiceLine = new FileOperation.InvoiceLine( itemName, itemPrice, itemCount, invoice);
    invoice.addInvLine(invoiceLine);
        frame.getInvoiceLTable().fireTableDataChanged();
        frame.getInvoiceHTable().fireTableDataChanged();
        frame.getInvTotalLbl().setText("" + invoice.getInvTotal());
      displayInvoices();   
    }

    
    }
