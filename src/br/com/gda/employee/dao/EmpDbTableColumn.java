package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class EmpDbTableColumn {
	private static final Hashtable<String, List<String>> tableColumns = new Hashtable<>();	
	
	static {
		buildTableColumns();
	}

	
	public static List<String> getTableColumns(String tableName) {
		List<String> resultColumns = tableColumns.get(tableName);
		
		if (resultColumns == null)
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		
		return resultColumns;
	}
	
	
	
	private static void buildTableColumns() {
		employeeWoerkingTimeTable();
	}
	
	
	
	private static void employeeWoerkingTimeTable() {
		List<String> columns = new ArrayList<>();		
		columns.add("cod_owner");
		columns.add("cod_store");
		columns.add("cod_employee");
		columns.add("weekday");
		columns.add("begin_time");
		columns.add("end_time");
		columns.add("record_mode");		
		tableColumns.put(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE, columns);
	}
}