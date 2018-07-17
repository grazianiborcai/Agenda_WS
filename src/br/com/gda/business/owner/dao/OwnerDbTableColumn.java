package br.com.gda.business.owner.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnTemplate;
import br.com.gda.sql.SqlColumn;

public final class OwnerDbTableColumn extends SqlDbTableColumnTemplate {
	private Hashtable<String, List<SqlColumn>> tableColumns;	
	
	public OwnerDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<SqlColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildOwnerTable();		
		return tableColumns;
	}
	
	
	
	private void buildOwnerTable() {
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
