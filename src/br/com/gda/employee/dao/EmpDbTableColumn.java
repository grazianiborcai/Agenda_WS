package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlColumn;

public final class EmpDbTableColumn {
	private static final Hashtable<String, List<SqlColumn>> tableColumns = new Hashtable<>();	
	
	static {
		buildTableColumns();
	}

	
	public static List<SqlColumn> getTableColumnsAsList(String tableName) {
		List<SqlColumn> columns = tableColumns.get(tableName);
		
		if (columns == null)
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		
		
		List<SqlColumn> resultColumns = new ArrayList<>();
		
		for (SqlColumn eachColumn : columns) {
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
	}
	
	
	
	public static Hashtable<String, SqlColumn> getTableColumnsAsHashTable(String tableName) {
		List<SqlColumn> columns = getTableColumnsAsList(tableName);
		Hashtable<String, SqlColumn> resultColumns = new Hashtable<>();
		
		for (SqlColumn eachColumns : columns) {
			resultColumns.put(eachColumns.columnName, eachColumns);
		}
		
		return resultColumns;
	}
	
	
	
	private static void buildTableColumns() {
		employeeWoerkingTimeTable();
	}
	
	
	
	private static void employeeWoerkingTimeTable() {
		boolean IS_PRIMARY_KEY = true;
		boolean NOT_PRIMARY_KEY = false;
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();	
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "cod_owner";
		oneColumn.isPK = IS_PRIMARY_KEY;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "cod_store";
		oneColumn.isPK = IS_PRIMARY_KEY;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "cod_employee";
		oneColumn.isPK = IS_PRIMARY_KEY;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "weekday";
		oneColumn.isPK = IS_PRIMARY_KEY;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "begin_time";
		oneColumn.isPK = NOT_PRIMARY_KEY;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "end_time";
		oneColumn.isPK = NOT_PRIMARY_KEY;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.columnName = "record_mode";
		oneColumn.isPK = NOT_PRIMARY_KEY;
		columns.add(oneColumn);
		
		tableColumns.put(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE, columns);
	}
}