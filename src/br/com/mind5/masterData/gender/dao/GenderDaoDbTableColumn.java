package br.com.mind5.masterData.gender.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class GenderDaoDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_GENDER = DaoDbField.COL_COD_GENDER;
	public static final String COL_COD_LANGUAGE = DaoDbField.COL_COD_LANGUAGE;
	public static final String COL_NAME = DaoDbField.COL_NAME;
	
	
	public GenderDaoDbTableColumn() {
		super();
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		final String TABLE_NAME = DaoDbTable.GENDER_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();			
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_GENDER;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);		
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.GENDER_TEXT_TABLE;
		oneColumn.columnName = COL_COD_LANGUAGE;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = DaoDbTable.GENDER_TEXT_TABLE;
		oneColumn.columnName = COL_NAME;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = IS_LOOKUP_COLUMN;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		Hashtable<String, List<DaoColumn>> results = new Hashtable<>();
		results.put(TABLE_NAME, columns);
		return results;
	}
}
