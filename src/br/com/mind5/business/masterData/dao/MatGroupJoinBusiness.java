package br.com.mind5.business.masterData.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatGroupJoinBusiness implements DaoJoinBuilder {
	private final String leftTable;
	private final String codLanguage;
	
	
	public MatGroupJoinBusiness(String leftTableName, String codLanguage) {
		leftTable = leftTableName;
		this.codLanguage = codLanguage;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_BUSINESS);
		helper.addConstraintEqual(DaoDbField.COL_COD_LANGUAGE, codLanguage);
		helper.addJoinType(DaoJoinType.INNER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.BUSINESS_AREA_TEXT_TABLE);		
		
		return helper.build();
	}
}
