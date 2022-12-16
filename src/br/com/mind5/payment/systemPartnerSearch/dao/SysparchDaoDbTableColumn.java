package br.com.mind5.payment.systemPartnerSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class SysparchDaoDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_PAY_PARTNER = DaoDbField.COL_COD_PAY_PARTNER;
	public static final String COL_ID_PAY_PARTNER_APP = DaoDbField.COL_ID_PAY_PARTNER_APP;	
	public static final String COL_ID_PAY_PARTNER_SYSTEM = DaoDbField.COL_ID_PAY_PARTNER_SYSTEM;
	
	
	public SysparchDaoDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		final String TABLE_NAME = DaoDbTable.PAY_PARTNER_MARKETPLACE_TABLE;
		
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

		Hashtable<String, List<DaoColumn>> results = new Hashtable<>();
		results.put(DaoDbTable.SYS_PAY_PARTNER_SEARCH_VIEW, columns);
		return results;
	}
}
