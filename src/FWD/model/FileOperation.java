package FWD.model;
// Author: Andrew Emil
import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileOperation {
  private int invNum;
private String customerName;
private Date invDate;
private ArrayList<InvoiceLine> lines;


    //  new ArrayList<>();
    public FileOperation(int invNum, String customerName, Date invDate) {
        this.invNum = invNum;
        this.customerName = customerName;
        this.invDate = invDate;

    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        String str="InvoiceFram1{" + "invNum=" + invNum + ", customerName=" + customerName + ", invDate=" + invDate + '}' ;
       for(InvoiceLine line: getLines()){
           str += "\n\t" + line;
       } 
        return str;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null)
            lines = new ArrayList<>();
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }

    public double getInvTotal() {
        double total = 0.0;
        for (InvoiceLine line : getLines()){
            total += line.getLineTotal();
        }
        return total;
    }

     public void addInvLine(InvoiceLine line){
        getLines().add(line);
        
     }
 public String getDataAsCSV() {
        DateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvNum() + "," + dateF.format(getInvDate()) + "," + getCustomerName();
}

    public static class invoiceHTable extends AbstractTableModel {

        private List<FileOperation> invoicesArray;
        private DateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");
        public invoiceHTable(List<FileOperation>invoicesArray) {
        this.invoicesArray = invoicesArray;

        }


        @Override
        public int getRowCount() {
    return invoicesArray.size();
        }
     public List<FileOperation> getInvoicesArray() {
            return invoicesArray;
        }


        @Override
        public int getColumnCount() {
            return 4;
        }



    @Override
        public String getColumnName(int columnIndex){
          switch (columnIndex) {
              case 0 :
                  return "invoice Num";
              case 1 :
                  return "Invoice Date";
              case 2 :
                  return "Customer Name";
              case 3 :
                  return "Invoice Total";
              default:
                  return "";
          }
        }
       @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            FileOperation row =invoicesArray.get(rowIndex);
            switch(columnIndex){
                case 0: return row.getInvNum();
                case 1 : return dateF.format(row.getInvDate());
                case 2 : return row.getCustomerName();
                case 3 : return row.getInvTotal();
                default:
                return null;
        }
    }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
              case 0 :
                  return Integer.class;
              case 1 :
                  return String.class;
              case 2 :
                  return String.class;
              case 3 :
                  return Double.class;
              default:
                  return Object.class;
        }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
        }





     }

    public static class InvoiceLine {
    private int  itemNumber;
    private String itemName;
    private double itemPrice;
    private int itemCount;
    private double lineTotal;
    private FileOperation header;

        public InvoiceLine(  String itemName, double itemPrice, int itemCount, FileOperation header) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemCount = itemCount;
            this.header = header;
            this.setLineTotal(this.itemCount*this.itemPrice);
        }


        public FileOperation getHeader() {
            return header;
        }

        public void setHeader(FileOperation header) {
            this.header = header;
        }

        public String getItemName() {
            return itemName;
        }



        public double getItemPrice() {
            return itemPrice;
        }



        public int getItemCount() {
            return itemCount;
        }

        public void setItemCount(int itemCount) {
            this.itemCount = itemCount;
        }

        public double getLineTotal(){
            return lineTotal;
        }

        private void setLineTotal(double lineTotal) {
    this.lineTotal = lineTotal;
      }
         public String getDataAsCSV() {
            return "" + getHeader().getInvNum() + "," + getItemName() + "," + getItemPrice() + "," + getItemCount();
        }
    }

    public static class invoiceLTable extends AbstractTableModel {

        private List<InvoiceLine>invoiceLines;
        private DateFormat dateF = new SimpleDateFormat("dd-MM-yyyy");

        public invoiceLTable(List<InvoiceLine>invoiceLines) {
        this.invoiceLines = invoiceLines;

        }

       public List<InvoiceLine> getInvoiceLines() {
            return invoiceLines;
        }
        @Override
        public int getRowCount() {
    return invoiceLines.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }



    @Override
        public String getColumnName(int columnIndex){
          switch (columnIndex) {
              case 0 :
                  return "Item Name";
              case 1 :
                  return "item Price";
              case 2 :
                  return "Count";
              case 3 :
                  return "Line Total";
              default:
                  return "";
          }
        }
       @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            InvoiceLine row =invoiceLines.get(rowIndex);
            switch(columnIndex){
                case 0: return row.getItemName();
                case 1 : return row.getItemPrice();
                case 2 : return row.getItemCount();
                case 3 : return row.getLineTotal();
                default:
                return null;
        }
    }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
              case 0 :
                  return String.class;
              case 1 :
                  return Double.class;
              case 2 :
                  return Integer.class;
              case 3 :
                  return Double.class;
              default:
                  return Object.class;
        }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
        }


     }
}
