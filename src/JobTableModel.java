/**
@filename: JobTableModel.java
@date: 7/1/18
@author skingroberson
@purpose: Defines the table model for jobs 
**/
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class JobTableModel extends AbstractTableModel {

    private ArrayList<RowData> rows;

    public JobTableModel() {
        rows = new ArrayList<RowData>();
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "Port";
                break;
            case 1:
                name = "Dock";
                break;
            case 2:
                name = "Ship";
                break;
            case 3:
                name = "Job";
                break;
            case 4:
            		name = "Person";
            		break;
            case 5:
                name = "Progress";
                break;
            case 6:
                name = "Status";
                break;
            case 7:
                name = "Cancel";
                break;
            case 8:
            		name = "Pause";
            		break;
        }
        return name;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RowData rowData = rows.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = rowData.portName;
                break;
            case 1:
                value = rowData.dockName;
                break;
            case 2:
                value = rowData.shipName;
                break;
            case 3:
                value = rowData.job.getName();
                break;
            case 4:
            		value = rowData.personName;
            		break;
            case 5:
                value = rowData.job.getProgress();
                break;
            case 6:
                value = rowData.job.getStatus();
                break;
            case 7:
                value = "Cancel";
                break;
            case 8:
                String status = rowData.job.getStatus();
                if(status == "Paused") {
            			value = "Resume";
                } else {
                		value = "Paused";
                }
                break;
        }
        return value;
    }
    
	public void setRowData(ArrayList<RowData> rows) {
        this.rows = rows;
        fireTableRowsUpdated(0, rows.size() - 1);
    }
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 7 || columnIndex == 8;
	}

	public Job getJobAtRow(int rowIndex) {
		RowData rowData = rows.get(rowIndex);
		return rowData.job;
	}
}