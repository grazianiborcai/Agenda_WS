package br.com.mind5.masterData.materialUnitSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoMatunitarchDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_LANGUAGE = DaoDbField.COL_COD_LANGUAGE;
	public static final String COL_COD_UNIT = DaoDbField.COL_COD_UNIT;
	public static final String COL_NAME = DaoDbField.COL_NAME;
	
	
	public DaoMatunitarchDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		final String TABLE_NAME = DaoDbTable.MAT_UNIT_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_UNIT;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MAT_UNIT_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MAT_UNIT_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		Hashtable<String, List<DaoColumn>> results = new Hashtable<>();
		results.put(DaoDbTable.MAT_UNIT_SEARCH_VIEW, columns);
		return results;
	}
}
