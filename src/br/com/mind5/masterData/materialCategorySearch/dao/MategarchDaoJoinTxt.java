package br.com.mind5.masterData.materialCategorySearch.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class MategarchDaoJoinTxt implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public MategarchDaoJoinTxt(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_MAT_CATEG);	
		helper.addJoinType(DaoJoinType.LEFT_OUTER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.MAT_CATEG_TEXT_TABLE);
		
		return helper.build();
	}
}
