package br.com.mind5.business.cartReserve.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class CarterveJoinCart implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public CarterveJoinCart(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoin join = new DaoJoin();
		join.rightTableName = DaoDbTable.CART_HDR_TABLE;
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
		oneColumn.leftColumnName = DaoDbField.COL_COD_USER;
		oneColumn.rightColumnName = DaoDbField.COL_COD_USER;
		joinColumns.add(oneColumn);
		
		return joinColumns;
	}
}
