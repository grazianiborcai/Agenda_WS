package br.com.mind5.webhook.moipMultipayment.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class WokaymoipDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER; 	
	public static final String COL_COD_PAY_ORDER = DaoDbField.COL_COD_PAY_ORDER; 
	public static final String COL_ID_PAYMENT_PARTNER = DaoDbField.COL_ID_PAYMENT_PARTNER;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public WokaymoipDbTableColumn() {
		super(WokaymoipDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPaymentView();	
		return tableColumns;
	}
	
	
	
	private void buildPaymentView() {
		final String TABLE_NAME = DaoDbTable.PAY_ORDER_HDR_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_PAY_ORDER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = IS_AUTO_INCREMENTED;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_OWNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_ID_PAYMENT_PARTNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		tableColumns.put(DaoDbTable.PAYMENT_VIEW, columns);
	}
}
