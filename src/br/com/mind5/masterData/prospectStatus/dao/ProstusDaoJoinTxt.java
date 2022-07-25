package br.com.mind5.masterData.prospectStatus.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class ProstusDaoJoinTxt implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public ProstusDaoJoinTxt(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_PROSPECT_STATUS);
		helper.addJoinType(DaoJoinType.INNER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.PROSPECT_STATUS_TEXT_TABLE);
		
		return helper.build();
	}
}
