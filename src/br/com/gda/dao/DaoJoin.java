package br.com.gda.dao;

import java.util.ArrayList;
import java.util.List;

public final class DaoJoin implements Cloneable {
	public String rightTableName;
	public List<DaoJoinColumn> joinColumns;
	public DaoJoinType joinType;
	public String constraintClause;
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		DaoJoin deepCopy = (DaoJoin) super.clone();
		
		if (joinColumns != null) {
			deepCopy.joinColumns = new ArrayList<>();
			
			for (DaoJoinColumn eachSqlJoinColumn : joinColumns) {
				DaoJoinColumn clonedJoinColumn = (DaoJoinColumn) eachSqlJoinColumn.clone();
				deepCopy.joinColumns.add(clonedJoinColumn);
			}
		}
		
		return deepCopy;
	}
}
