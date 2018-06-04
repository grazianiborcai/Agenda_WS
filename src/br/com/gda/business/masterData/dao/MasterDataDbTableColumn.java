package br.com.gda.business.masterData.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlColumn;

public final class MasterDataDbTableColumn {
	private static final boolean IS_PRIMARY_KEY = true;	
	private static final boolean IS_LOOKUP_COLUMN = true;
	private static final boolean NEGATIVE = false;
	
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
	
	
	
	private static void buildTableColumns() {
		positionTable();	
		materialUnitTable();
		materialTypeTable();
		materialCategTable();
		materialGroupTable();
		businessAreaTable();
		currencyTable();
		languageTable();
	}
	
	
	
	private static void positionTable() {
		final String TABLE_NAME = SqlDbTable.POSITION_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_position";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.POSITION_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.POSITION_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void materialUnitTable() {
		final String TABLE_NAME = SqlDbTable.MATERIAL_UNIT_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Unit";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_UNIT_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_UNIT_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void materialTypeTable() {
		final String TABLE_NAME = SqlDbTable.MATERIAL_TYPE_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_type";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_TYPE_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void materialCategTable() {
		final String TABLE_NAME = SqlDbTable.MATERIAL_CATEGORY_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_category";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_CATEGORY_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_CATEGORY_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void materialGroupTable() {
		final String TABLE_NAME = SqlDbTable.MATERIAL_GROUP_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_group";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_business";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_GROUP_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.MATERIAL_GROUP_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.BUSINESS_AREA_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void businessAreaTable() {
		final String TABLE_NAME = SqlDbTable.BUSINESS_AREA_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_business";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.BUSINESS_AREA_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.BUSINESS_AREA_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void currencyTable() {
		final String TABLE_NAME = SqlDbTable.CURRENCY_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Cod_curr";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = "Symbol";
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.CURRENCY_TEXT_TABLE;
		oneColumn.columnName = "Language";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new SqlColumn();
		oneColumn.tableName = SqlDbTable.CURRENCY_TEXT_TABLE;
		oneColumn.columnName = "Name";
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private static void languageTable() {
		final String TABLE_NAME = SqlDbTable.LANGUAGE_TABLE;
		
		SqlColumn oneColumn;
		List<SqlColumn> columns = new ArrayList<>();			
		
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
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		tableColumns.put(TABLE_NAME, columns);
	}
}
