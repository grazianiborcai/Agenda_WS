package br.com.mind5.payment.payOrderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class DaoPayordemInsert implements DaoStmtExec<PayordemInfo> {
	private DaoStmtExec<PayordemInfo> helper;
	
	
	public DaoPayordemInsert(List<DaoStmtExecOption<PayordemInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPayordemInsertSingle.class, PayordemInfo.class);
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
