package br.com.gda.business.customerSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.business.customer.dao.CusDbTableColumn;
import br.com.gda.business.person.dao.PersonDbTableColumn;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnTemplate;
import br.com.gda.dao.common.DaoDbTable;

public final class CusarchDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_CUSTOMER = CusDbTableColumn.COL_COD_CUSTOMER;
	public static final String COL_COD_ENTITY_CATEG = PersonDbTableColumn.COL_COD_ENTITY_CATEG;
	public static final String COL_COD_GENDER = PersonDbTableColumn.COL_COD_GENDER;
	public static final String COL_COD_LANGUAGE = "language";
	public static final String COL_COD_OWNER = CusDbTableColumn.COL_COD_OWNER;
	public static final String COL_COD_PERSON = PersonDbTableColumn.COL_COD_PERSON;		
	public static final String COL_CPF = PersonDbTableColumn.COL_CPF;
	public static final String COL_EMAIL = PersonDbTableColumn.COL_EMAIL;
	public static final String COL_RECORD_MODE = CusDbTableColumn.COL_RECORD_MODE;	
	
	
	
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
		oneColumn.tableName = DaoDbTable.LANGUAGE_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(DaoDbTable.PERSON_SEARCH_VIEW, columns);
	}
}
