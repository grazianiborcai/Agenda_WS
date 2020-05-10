package br.com.mind5.payment.payOrderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class DaoPayordemInsert implements DaoStmtExecV2<PayordemInfo> {
	private DaoStmtExecV2<PayordemInfo> helper;
	
	
	public DaoPayordemInsert(List<DaoStmtExecOption<PayordemInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayordemInsertSingle.class, PayordemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
