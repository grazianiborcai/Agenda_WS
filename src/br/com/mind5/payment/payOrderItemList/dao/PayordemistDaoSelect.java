package br.com.mind5.payment.payOrderItemList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class PayordemistDaoSelect implements DaoStmtExec<PayordemistInfo> {
	private DaoStmtExec<PayordemistInfo> helper;
	
	
	public PayordemistDaoSelect(List<DaoStmtExecOption<PayordemistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayordemistDaoSelectSingle.class, PayordemistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
