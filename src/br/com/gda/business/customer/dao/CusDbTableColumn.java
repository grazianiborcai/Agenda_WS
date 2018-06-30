package br.com.gda.business.customer.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnTemplate;

public final class CusDbTableColumn extends SqlDbTableColumnTemplate {
	private Hashtable<String, List<SqlColumn>> tableColumns;	
	
	public CusDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<SqlColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildCustomerTable();		
		return tableColumns;
	}
	
	
	
	private void buildCustomerTable() {
		final String TABLE_NAME = SqlDbTable.CUS_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();	
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "cod_owner";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_customer";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = IS_AUTO_INCREMENTED;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "CPF";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
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
		oneColumn.columnName = "Cod_gender";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Born_date";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "email";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Address1";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Address2";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Postalcode";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "City";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Country";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "State_province";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Phone";
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
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.GENDER_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.COUNTRY_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
