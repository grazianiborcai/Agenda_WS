package br.com.gda.sql;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import br.com.gda.common.SystemMessage;

public class SqlDbTableColumnTemplate implements SqlDbTableColumn {
	protected static final boolean IS_PRIMARY_KEY = true;	
	protected static final boolean IS_LOOKUP_COLUMN = true;
	protected static final boolean IS_AUTO_INCREMENTED = true;
	protected static final boolean NEGATIVE = false;
	
	private Hashtable<String, List<SqlColumn>> tableColumns;
	
	
	protected SqlDbTableColumnTemplate() {		
		buildTableColumns();
	}
	
	
	
	private void buildTableColumns() {
		tableColumns = buildTableColumnsHook();
	}
	
	
	
	protected Hashtable<String, List<SqlColumn>> buildTableColumnsHook() {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	@Override public List<String> getTableNamesAsList() {
		List<String> allTableNames = new ArrayList<>();		
		Iterator<Entry<String, List<SqlColumn>>> itrMapEntry = tableColumns.entrySet().iterator();
		
		while (itrMapEntry.hasNext()) {
			Entry<String, List<SqlColumn>> eachEntry = itrMapEntry.next();
			String tableName = eachEntry.getKey();
			allTableNames.add(tableName);
		}
		
		return allTableNames;
	}
	
	
	
	@Override public List<SqlColumn> getTableColumnsAsList(String tableName) {
		List<SqlColumn> columns = tableColumns.get(tableName);
		
		if (columns == null)
			throw new IllegalArgumentException(tableName + " " + SystemMessage.TABLE_NOT_FOUND);
		
		
		List<SqlColumn> resultColumns = new ArrayList<>();
		
		for (SqlColumn eachColumn : columns) {
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
	}
}
