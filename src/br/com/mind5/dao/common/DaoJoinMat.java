package br.com.mind5.dao.common;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoJoinMat implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public DaoJoinMat(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoin join = new DaoJoin();
		join.rightTableName = DaoDbTable.MAT_TABLE;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = getJoinColumns(leftTable);
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private List<DaoJoinColumn> getJoinColumns(String leftTableName) {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_COD_MATERIAL;
		oneColumn.rightColumnName = DaoDbField.COL_COD_MATERIAL;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_COD_OWNER;
		oneColumn.rightColumnName = DaoDbField.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_RECORD_MODE;
		oneColumn.rightColumnName = DaoDbField.COL_RECORD_MODE;
		joinColumns.add(oneColumn);
		
		return joinColumns;
	}
}
