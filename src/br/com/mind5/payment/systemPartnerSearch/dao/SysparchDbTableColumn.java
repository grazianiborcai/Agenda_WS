package br.com.mind5.payment.systemPartnerSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class SysparchDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_ID_PAY_PARTNER_APP = DaoDbField.COL_ID_PAY_PARTNER_APP;	
	public static final String COL_ID_PAY_PARTNER_SYSTEM = DaoDbField.COL_ID_PAY_PARTNER_SYSTEM;	
	public static final String COL_COD_PAY_PARTNER = DaoDbField.COL_COD_PAY_PARTNER;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public SysparchDbTableColumn() {
		super(SysparchDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPayPartnerSystemTable();	
		return tableColumns;
	}
	
	
	
	private void buildPayPartnerSystemTable() {
		final String TABLE_NAME = DaoDbTable.SYS_PAY_PARTNER_TABLE;
		
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
		oneColumn.columnName = COL_ID_PAY_PARTNER_SYSTEM;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_ID_PAY_PARTNER_APP;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		tableColumns.put(DaoDbTable.SYS_PAY_PARTNER_SEARCH_VIEW, columns);
	}
}
