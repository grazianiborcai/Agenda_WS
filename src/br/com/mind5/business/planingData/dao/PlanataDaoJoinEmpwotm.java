package br.com.mind5.business.planingData.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoDictionary;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class PlanataDaoJoinEmpwotm implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public PlanataDaoJoinEmpwotm(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoin join = new DaoJoin();
		join.rightTableName = DaoDbTable.EMP_WT_TABLE;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = getJoinColumns(leftTable);
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private List<DaoJoinColumn> getJoinColumns(String leftTableName) {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		DaoJoinColumn oneColumn;
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_COD_OWNER;
		oneColumn.rightColumnName = DaoDbField.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_COD_STORE;
		oneColumn.rightColumnName = DaoDbField.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_COD_WEEKDAY;
		oneColumn.rightColumnName = DaoDbField.COL_COD_WEEKDAY;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_BEGIN_TIME;
		oneColumn.rightColumnName = DaoDbField.COL_BEGIN_TIME;
		oneColumn.condition = DaoDictionary.LESS_THAN_OR_EQUAL_TO;
		joinColumns.add(oneColumn);		
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_END_TIME;
		oneColumn.rightColumnName = DaoDbField.COL_END_TIME;
		oneColumn.condition = DaoDictionary.GREATER_THAN_OR_EQUAL_TO;
		joinColumns.add(oneColumn);	
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = leftTableName;
		oneColumn.leftColumnName = DaoDbField.COL_RECORD_MODE;
		oneColumn.rightColumnName = DaoDbField.COL_RECORD_MODE;
		joinColumns.add(oneColumn);
		
		return joinColumns;
	}
}
