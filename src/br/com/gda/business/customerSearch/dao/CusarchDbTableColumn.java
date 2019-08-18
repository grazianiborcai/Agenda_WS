package br.com.gda.business.customerSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.phone.dao.PhoneDbTableColumn;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnTemplate;
import br.com.gda.dao.common.DaoDbField;
import br.com.gda.dao.common.DaoDbTable;

public final class CusarchDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_CUSTOMER = DaoDbField.COL_COD_CUSTOMER;
	public static final String COL_COD_ENTITY_CATEG = DaoDbField.COL_COD_ENTITY_CATEG;
	public static final String COL_COD_GENDER = DaoDbField.COL_COD_GENDER;
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;
	public static final String COL_COD_PERSON = DaoDbField.COL_COD_PERSON;	
	public static final String COL_COD_USER = DaoDbField.COL_COD_USER;	
	public static final String COL_COUNTRY_PHONE = PhoneDbTableColumn.COL_COUNTRY_PHONE;
	public static final String COL_CPF = DaoDbField.COL_CPF;
	public static final String COL_EMAIL = DaoDbField.COL_EMAIL;
	public static final String COL_FULL_NUMBER = PhoneDbTableColumn.COL_FULL_NUMBER;
	public static final String COL_RECORD_MODE = DaoDbField.COL_RECORD_MODE;	
		
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	
	public CusarchDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildCustomerSearchView();		
		return tableColumns;
	}
	
	
	
	private void buildCustomerSearchView() {
		final String TABLE_NAME = DaoDbTable.PERSON_TABLE;
		
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
		oneColumn.columnName = COL_COD_ENTITY_CATEG;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_PERSON;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_GENDER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.CUS_TABLE;
		oneColumn.columnName = COL_COD_CUSTOMER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.CUS_TABLE;
		oneColumn.columnName = COL_COD_USER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_CPF;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_EMAIL;
		oneColumn.isPK = NEGATIVE;
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
		oneColumn.tableName = DaoDbTable.PHONE_TABLE;
		oneColumn.columnName = COL_COUNTRY_PHONE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.PHONE_TABLE;
		oneColumn.columnName = COL_FULL_NUMBER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(DaoDbTable.CUS_SEARCH_VIEW, columns);
	}
}
