package br.com.mind5.payment.payOrder.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class PayordDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_AMOUNT_CURRENCY_PARTNER = DaoDbField.COL_AMOUNT_CURRENCY_PARTNER;
	public static final String COL_AMOUNT_TOTAL_PARTNER = DaoDbField.COL_AMOUNT_TOTAL_PARTNER;
	public static final String COL_COD_CREDIT_CARD = DaoDbField.COL_COD_CREDIT_CARD;
	public static final String COL_COD_ORDER = DaoDbField.COL_COD_ORDER;
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;	
	public static final String COL_COD_PAY_CUSTOMER = DaoDbField.COL_COD_PAY_CUSTOMER;
	public static final String COL_COD_PAY_ORDER = DaoDbField.COL_COD_PAY_ORDER;
	public static final String COL_CREATED_ON = DaoDbField.COL_CREATED_ON ;
	public static final String COL_ID_ORDER_PARTNER = DaoDbField.COL_ID_ORDER_PARTNER;
	public static final String COL_ID_PAYMENT_PARTNER = DaoDbField.COL_ID_PAYMENT_PARTNER;
	public static final String COL_LAST_CHANGED = DaoDbField.COL_LAST_CHANGED;
	public static final String COL_STATUS_ORDER_PARTNER = DaoDbField.COL_STATUS_ORDER_PARTNER;
	public static final String COL_STATUS_PAYMENT_PARTNER = DaoDbField.COL_STATUS_PAYMENT_PARTNER;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public PayordDbTableColumn() {
		super(PayordDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPayOrderTable();	
		return tableColumns;
	}
	
	
	
	private void buildPayOrderTable() {
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
		oneColumn.columnName = COL_COD_ORDER;
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
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_CREATED_ON;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_PAY_CUSTOMER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_CREDIT_CARD;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_ID_ORDER_PARTNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_STATUS_ORDER_PARTNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_AMOUNT_TOTAL_PARTNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_AMOUNT_CURRENCY_PARTNER;
		oneColumn.isPK = NEGATIVE;
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
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_STATUS_PAYMENT_PARTNER;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		tableColumns.put(TABLE_NAME, columns);
	}
}
