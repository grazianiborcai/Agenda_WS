package br.com.gda.webhook.moipRefund.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnTemplate;
import br.com.gda.dao.common.DaoDbTable;

public final class WokefumoipDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_OWNER = "cod_owner";	
	public static final String COL_COD_PAY_ORDER = "cod_pay_order";
	public static final String COL_ID_PAYMENT_PARTNER = "id_payment_partner";
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public WokefumoipDbTableColumn() {
		super(WokefumoipDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildRefundView();	
		return tableColumns;
	}
	
	
	
	private void buildRefundView() {
		final String TABLE_NAME = DaoDbTable.PAY_ORDER_ITM_TABLE;
		
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

		tableColumns.put(DaoDbTable.REFUND_VIEW, columns);
	}
}
