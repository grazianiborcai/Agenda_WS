package br.com.mind5.dao;

import java.util.ArrayList;
import java.util.List;

public final class DaoJoin implements Cloneable {
	public String rightTableName;
	public List<DaoJoinColumn> joinColumns;
	public DaoJoinType joinType;
	public String constraintClause;
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		DaoJoin deepCopy = new DaoJoin();
		
		deepCopy.rightTableName = rightTableName;
		deepCopy.joinType = joinType;
		deepCopy.constraintClause = constraintClause;
		deepCopy.joinColumns = cloneJoinColumns(joinColumns);
		
		return deepCopy;
	}
	
	
	
	private List<DaoJoinColumn> cloneJoinColumns(List<DaoJoinColumn> sources) throws CloneNotSupportedException {
		if (sources == null)
			return null;
		
		List<DaoJoinColumn> results = new ArrayList<>();
		
		for (DaoJoinColumn eachSource : sources) {
			DaoJoinColumn clonedSource = (DaoJoinColumn) eachSource.clone();
			results.add(clonedSource);
		}
		
		return results;
	}
}
