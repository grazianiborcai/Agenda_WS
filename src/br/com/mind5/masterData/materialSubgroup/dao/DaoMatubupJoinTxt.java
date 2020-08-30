package br.com.mind5.masterData.materialSubgroup.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoMatubupJoinTxt implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public DaoMatubupJoinTxt(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_MAT_SUBGROUP);	
		helper.addColumn(DaoDbField.COL_COD_MAT_GROUP);	
		helper.addJoinType(DaoJoinType.INNER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.MAT_SUBGROUP_TEXT_TABLE);
		
		return helper.build();
	}
}
