package br.com.mind5.payment.countryPartner.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class CounparDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_COUNTRY =  DaoDbField.COL_COD_COUNTRY;	
	public static final String COL_COD_PAY_PARTNER = DaoDbField.COL_COD_PAY_PARTNER;
	public static final String COL_IS_DEFAULT = DaoDbField.COL_IS_DEFAULT;
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;
	
	
	public CounparDbTableColumn() {
		super(CounparDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();		
		buildPayPartnerCountryTable();	
		return tableColumns;
	}
	
	
	
	private void buildPayPartnerCountryTable() {
		final String TABLE_NAME = DaoDbTable.PAY_PARTNER_COUNTRY_TABLE;
		
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
