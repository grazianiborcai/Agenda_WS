package br.com.gda.business.material.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.sql.DbTable;
import br.com.gda.sql.SqlColumn;

public final class MatDbTableColumn {
	private static final boolean IS_PRIMARY_KEY = true;	
	private static final boolean IS_LOOKUP_COLUMN = true;
	private static final boolean IS_AUTO_INCREMENTED = true;
	private static final boolean NEGATIVE = false;
	
	private static final Hashtable<String, List<SqlColumn>> tableColumns = new Hashtable<>();	
	
	
	
	static {
		buildTableColumns();
	}
	
	
	
	private static void buildTableColumns() {
		buildMatTable();	
		buildMatTextTable();
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
		final String TABLE_NAME = DbTable.MATERIAL_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();	
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_owner";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_material";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = IS_AUTO_INCREMENTED;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Price";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_type";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_category";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_curr";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Unit";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Price_unit";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_group";
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
		oneColumn.tableName = DbTable.MATERIAL_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.MATERIAL_TEXT_TABLE;
		oneColumn.columnName = "Description";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.MATERIAL_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.MATERIAL_TYPE_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.MATERIAL_CATEGORY_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.CURRENCY_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.UNIT_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.MATERIAL_GROUP_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.MATERIAL_GROUP_TABLE;
		oneColumn.columnName = "Cod_business";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = DbTable.BUSINESS_AREA_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void buildMatTextTable() {
		final String TABLE_NAME = DbTable.MATERIAL_TEXT_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();	
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_owner";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_material";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Language";
		oneColumn.isPK = IS_PRIMARY_KEY;
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
		oneColumn.columnName = "Description";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
