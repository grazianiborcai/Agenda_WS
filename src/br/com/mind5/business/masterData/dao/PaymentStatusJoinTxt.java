package br.com.mind5.business.masterData.dao;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoJoinBuilderHelper;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.common.DaoDbField;
import br.com.mind5.dao.common.DaoDbTable;

public final class PaymentStatusJoinTxt implements DaoJoinBuilder {
	private final String leftTable;
	
	
	public PaymentStatusJoinTxt(String leftTableName) {
		leftTable = leftTableName;
	}

	
	
	@Override public DaoJoin build() {
		DaoJoinBuilderHelper helper = new DaoJoinBuilderHelper(this.getClass());
		
		helper.addColumn(DaoDbField.COL_COD_PAYMENT_STATUS);	
		helper.addJoinType(DaoJoinType.INNER_JOIN);		
		helper.addLeftTable(leftTable);
		helper.addRightTable(DaoDbTable.PAYMENT_STATUS_TEXT_TABLE);
		
		return helper.build();
	}
}
