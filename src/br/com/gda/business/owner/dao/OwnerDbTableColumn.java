package br.com.gda.business.owner.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlColumn;

public final class OwnerDbTableColumn {
	private static final boolean IS_PRIMARY_KEY = true;	
	//private static final boolean IS_LOOKUP_COLUMN = true;
	private static final boolean IS_AUTO_INCREMENTED = true;
	private static final boolean NEGATIVE = false;
	
	private static final Hashtable<String, List<SqlColumn>> tableColumns = new Hashtable<>();	
	
	
	
	static {
		buildTableColumns();
	}
	
	
	
	private static void buildTableColumns() {
		buildMatTable();	
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
	
	
	
	private static void buildMatTable() {
		final String TABLE_NAME = SqlDbTable.OWNER_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();	
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_owner";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = IS_AUTO_INCREMENTED;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "record_mode";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
