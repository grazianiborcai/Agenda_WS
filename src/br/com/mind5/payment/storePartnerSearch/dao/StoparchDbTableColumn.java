package br.com.mind5.payment.storePartnerSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class StoparchDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;	
	public static final String COL_COD_PAY_PARTNER = DaoDbField.COL_COD_PAY_PARTNER;
	public static final String COL_COD_STORE = DaoDbField.COL_COD_STORE;
	public static final String COL_CODE_PAY_PARTNER_STORE = DaoDbField.COL_CODE_PAY_PARTNER_STORE;
	public static final String COL_ID_PAY_PARTNER_STORE = DaoDbField.COL_ID_PAY_PARTNER_STORE;
	public static final String COL_RECORD_MODE = DaoDbField.COL_RECORD_MODE;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public StoparchDbTableColumn() {
		super(StoparchDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPayPartnerStoreTable();	
		return tableColumns;
	}
	
	
	
	private void buildPayPartnerStoreTable() {
		final String TABLE_NAME = DaoDbTable.PAY_PARTNER_STORE_TABLE;
		
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
		oneColumn.columnName = COL_COD_PAY_PARTNER;
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
		oneColumn.columnName = COL_CODE_PAY_PARTNER_STORE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_ID_PAY_PARTNER_STORE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		tableColumns.put(DaoDbTable.PAY_PARTNER_STORE_SEARCH_VIEW, columns);
	}
}
