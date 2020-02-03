package br.com.mind5.payment.ownerPartner.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class OwnparDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_OWNER = DaoDbField.COL_COD_OWNER;	
	public static final String COL_COD_PAY_PARTNER = DaoDbField.COL_COD_PAY_PARTNER;
	public static final String COL_IS_DEFAULT = DaoDbField.COL_IS_DEFAULT;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public OwnparDbTableColumn() {
		super(OwnparDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPayPartnerOwnerTable();	
		return tableColumns;
	}
	
	
	
	private void buildPayPartnerOwnerTable() {
		final String TABLE_NAME = DaoDbTable.PAY_PARTNER_OWNER_TABLE;
		
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
		oneColumn.columnName = COL_COD_PAY_PARTNER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_IS_DEFAULT;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		tableColumns.put(TABLE_NAME, columns);
	}
}
