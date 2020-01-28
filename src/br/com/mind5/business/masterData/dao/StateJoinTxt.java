package br.com.mind5.business.masterData.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class StateJoinTxt implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public StateJoinTxt(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_COUNTRY);	
		helper.addColumn(DaoDbField.COL_STATE_PROVINCE);
		helper.addJoinType(DaoJoinType.INNER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.STATE_TEXT_TABLE);
		
		return helper.build();
	}
}
