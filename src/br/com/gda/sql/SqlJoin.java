package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

public final class SqlJoin implements Cloneable {
	public String rightTableName;
	public List<SqlJoinColumn> joinColumns;
	public SqlJoinType joinType;
	public String constraintClause;
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		SqlJoin deepCopy = (SqlJoin) super.clone();
		
		if (joinColumns != null) {
			deepCopy.joinColumns = new ArrayList<>();
			
			for (SqlJoinColumn eachSqlJoinColumn : joinColumns) {
				SqlJoinColumn clonedJoinColumn = (SqlJoinColumn) eachSqlJoinColumn.clone();
				deepCopy.joinColumns.add(clonedJoinColumn);
			}
		}
		
		return deepCopy;
	}
}
