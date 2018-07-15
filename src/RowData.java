/**
@filename: RowData.java
@date: 7/1/18
@author skingroberson
@purpose: One row of data for JTable
**/
public class RowData {

    public String portName;
    public String dockName;
    public String shipName;
    public String personName;
    public Job job;

    public RowData(String portName, String dockName, String shipName, Job job) {
    		this.portName = portName;
    		this.dockName = dockName;
    		this.shipName = shipName;
    		this.job = job;
    		this.personName = job.getPersonName();
    }
}