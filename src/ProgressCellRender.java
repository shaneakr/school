/**
@filename: ProgressCellRender.java
@date: 7/1/18
@author skingroberson
@purpose: renders Progress bars in JTable
**/
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ProgressCellRender extends JProgressBar implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    		int progress = Math.round( (Float) value * 100.0f );
        setValue(progress);
        return this;
    }
}