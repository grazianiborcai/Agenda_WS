package br.com.mind5.masterData.bankAccountTypeSearch.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class BankacyperchDaoJoinTxt implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public BankacyperchDaoJoinTxt(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_BANK_ACCOUNT_TYPE);
		helper.addColumn(DaoDbField.COL_COD_BANK_ACCOUNT_TYPE);	
		helper.addJoinType(DaoJoinType.LEFT_OUTER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.BANK_ACCOUNT_TYPE_TEXT_TABLE);
		
		return helper.build();
	}
}
