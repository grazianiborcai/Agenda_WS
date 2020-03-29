package br.com.mind5.masterData.moonPhaseSearch.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class MoonasarchDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_LANGUAGE = DaoDbField.COL_COD_LANGUAGE ;
	public static final String COL_COD_MOON_PHASE = DaoDbField.COL_COD_MOON_PHASE;	
	public static final String COL_NAME = DaoDbField.COL_NAME;		
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public MoonasarchDbTableColumn() {
		super(MoonasarchDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		
		buildTable();
		
		return tableColumns;
	}
	
	
	
	private void buildTable() {
		final String TABLE_NAME = DaoDbTable.MOON_PHASE_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_MOON_PHASE;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MOON_PHASE_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.MOON_PHASE_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		tableColumns.put(DaoDbTable.MOON_PHASE_SEARCH_VIEW, columns);
	}
}
