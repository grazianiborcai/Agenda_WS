package br.com.mind5.file.filePath.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoDbTableColumnTemplate;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class FathDbTableColumn extends DaoDbTableColumnTemplate {
	public static final String COL_COD_FILE_PATH = DaoDbField.COL_COD_FILE_PATH;
	public static final String COL_FILE_PATH = DaoDbField.COL_FILE_PATH;	
	public static final String COL_FILE_PATH_EXTERNAL = DaoDbField.COL_FILE_PATH_EXTERNAL;	
		
	
	
	private Hashtable<String, List<DaoColumn>> tableColumns;	
	
	public FathDbTableColumn() {
		super(FathDbTableColumn.class);
	}
	
	
	
	@Override protected Hashtable<String, List<DaoColumn>> buildTableColumnsHook() {
		tableColumns = new Hashtable<>();
		
		buildFilePathTable();	
		
		return tableColumns;
	}
	
	
	
	private void buildFilePathTable() {
		final String TABLE_NAME = DaoDbTable.FILE_PATH_TABLE;
		
		DaoColumn oneColumn;
		List<DaoColumn> columns = new ArrayList<>();	
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_COD_FILE_PATH;
		oneColumn.isPK = IS_PRIMARY_KEY;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_FILE_PATH;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);
		
		oneColumn = new DaoColumn();
		oneColumn.tableName = TABLE_NAME;
		oneColumn.columnName = COL_FILE_PATH_EXTERNAL;
		oneColumn.isPK = NEGATIVE;
		oneColumn.isLookUp = NEGATIVE;
		oneColumn.isAutoIncremented = NEGATIVE;
		columns.add(oneColumn);

		tableColumns.put(TABLE_NAME, columns);
	}
}
