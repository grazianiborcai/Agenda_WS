package br.com.gda.business.storeEmployee.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnTemplate;

public final class StoreEmpDbTableColumn extends DaoDbTableColumnTemplate {
	
	public static final String COL_COD_EMPLOYEE = "cod_employee";
	public static final String COL_COD_LANGUAGE = "language";
	public static final String COL_COD_OWNER = "cod_owner";
	public static final String COL_COD_POSITION = "cod_position";
	public static final String COL_COD_STORE = "cod_store";
	public static final String COL_LAST_CHANGED = "last_changed";
	public static final String COL_RECORD_MODE = "record_mode";
	

	Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public StoreEmpDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		
		buildStoreEmployeeTable();
		
		return tableColumns;
	}
	
	
	
	private void buildStoreEmployeeTable() {
		final String TABLE_NAME = DaoDbTable.STORE_EMP_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_STORE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_EMPLOYEE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_POSITION;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_RECORD_MODE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_LAST_CHANGED;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.LANGUAGE_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
