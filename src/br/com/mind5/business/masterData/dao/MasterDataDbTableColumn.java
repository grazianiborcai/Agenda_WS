package br.com.mind5.business.masterData.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class MasterDataDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_AREA_PHONE = DaoDbField.COL_COD_AREA_PHONE;	
	public static final String COL_COD_AUTH_ROLE = DaoDbField.COL_COD_AUTH_ROLE;
	public static final String COL_COD_AUTH_GROUP = DaoDbField.COL_COD_AUTH_GROUP;
	public static final String COL_COD_BUSINESS = DaoDbField.COL_COD_BUSINESS;
	public static final String COL_COD_COUNTRY = DaoDbField.COL_COD_COUNTRY;
	public static final String COL_COD_COUNTRY_ALPHA3 = DaoDbField.COL_COD_COUNTRY_ALPHA3;
	public static final String COL_COD_COUNTRY_PHONE = DaoDbField.COL_COD_COUNTRY_PHONE;	
	public static final String COL_COD_CURRENCY = DaoDbField.COL_COD_CURRENCY;
	public static final String COL_COD_DAYPART = DaoDbField.COL_COD_DAYPART;
	public static final String COL_COD_ENTITY_CATEG = DaoDbField.COL_COD_ENTITY_CATEG;	
	public static final String COL_COD_FEE_CATEG = DaoDbField.COL_COD_FEE_CATEG;
	public static final String COL_COD_GENDER = DaoDbField.COL_COD_GENDER;
	public static final String COL_COD_ITEM_CATEG = DaoDbField.COL_COD_ITEM_CATEG;
	public static final String COL_COD_LANGUAGE = DaoDbField.COL_COD_LANGUAGE ;
	public static final String COL_COD_MAT_CATEG = DaoDbField.COL_COD_MAT_CATEG;
	public static final String COL_COD_MAT_GROUP = DaoDbField.COL_COD_MAT_GROUP;
	public static final String COL_COD_MAT_MOV_TYPE = DaoDbField.COL_COD_MAT_MOV_TYPE;
	public static final String COL_COD_MAT_TYPE = DaoDbField.COL_COD_MAT_TYPE;	
	public static final String COL_COD_ORDER_STATUS = DaoDbField.COL_COD_ORDER_STATUS;
	public static final String COL_COD_PAY_PARTNER = DaoDbField.COL_COD_PAY_PARTNER;
	public static final String COL_COD_PAYMENT_STATUS = DaoDbField.COL_COD_PAYMENT_STATUS;
	public static final String COL_COD_POSITION = DaoDbField.COL_COD_POSITION;	
	public static final String COL_COD_SCHEDULE_STATUS = DaoDbField.COL_COD_SCHEDULE_STATUS;
	public static final String COL_COD_SYS_ENVIRONMENT = DaoDbField.COL_COD_SYS_ENVIRONMENT;
	public static final String COL_COD_TIMEZONE = DaoDbField.COL_COD_TIMEZONE;
	public static final String COL_COD_UNIT = DaoDbField.COL_COD_UNIT;
	public static final String COL_COD_USER_CATEG = DaoDbField.COL_COD_USER_CATEG;
	public static final String COL_COD_WEEKDAY = DaoDbField.COL_COD_WEEKDAY;	
	public static final String COL_CURRENCY_SYMBOL = DaoDbField.COL_CURRENCY_SYMBOL;
	public static final String COL_DESCRIPTION = DaoDbField.COL_DESCRIPTION;
	public static final String COL_MONTH = DaoDbField.COL_MONTH;
	public static final String COL_NAME = DaoDbField.COL_NAME;
	public static final String COL_RECORD_MODE = DaoDbField.COL_RECORD_MODE;
	public static final String COL_STATE_PROVINCE = DaoDbField.COL_STATE_PROVINCE;
	
	
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public MasterDataDbTableColumn() {
		super(MasterDataDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		
		positionTable();
		countryLegalTable();
		cartItemCategTable();
		entityCategTable();
		payPartnerTable();
		userCategTable();
		matmovTypeTable();
		sysEnvironmentTable();
		scheduleStatusTable();
		scheduleMonthTable();
		
		return tableColumns;
	}
	
	
	
	private void positionTable() {
		final String TABLE_NAME = DaoDbTable.POSITION_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_POSITION;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.POSITION_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.POSITION_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void countryLegalTable() {
		final String TABLE_NAME = DaoDbTable.COUNTRY_LEGAL_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_COUNTRY;
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
		oneColumn.tableName = DaoDbTable.COUNTRY_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.COUNTRY_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void cartItemCategTable() {
		final String TABLE_NAME = DaoDbTable.CART_ITM_CATEG_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_ITEM_CATEG;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.CART_ITM_CATEG_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.CART_ITM_CATEG_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void entityCategTable() {
		final String TABLE_NAME = DaoDbTable.ENTITY_CATEG_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_ENTITY_CATEG;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.ENTITY_CATEG_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.ENTITY_CATEG_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void payPartnerTable() {
		final String TABLE_NAME = DaoDbTable.PAY_PARTNER_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_PAY_PARTNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_DESCRIPTION;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void userCategTable() {
		final String TABLE_NAME = DaoDbTable.USER_CATEG_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_USER_CATEG;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_CATEG_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.USER_CATEG_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void matmovTypeTable() {
		final String TABLE_NAME = DaoDbTable.MAT_MOV_TYPE_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_MAT_MOV_TYPE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MAT_MOV_TYPE_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MAT_MOV_TYPE_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void sysEnvironmentTable() {
		final String TABLE_NAME = DaoDbTable.SYS_ENVIRONMENT_TABLE ;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_SYS_ENVIRONMENT;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void scheduleStatusTable() {
		final String TABLE_NAME = DaoDbTable.SCHEDULE_STATUS_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_SCHEDULE_STATUS;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.SCHEDULE_STATUS_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.SCHEDULE_STATUS_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}
	
	
	
	private void scheduleMonthTable() {
		final String TABLE_NAME = DaoDbTable.MONTH_TEXT_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_MONTH;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(TABLE_NAME, columns);
	}	
}
