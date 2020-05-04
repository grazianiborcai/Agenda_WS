package br.com.mind5.payment.payOrder.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class DaoPayordUpdate implements DaoStmtExecV2<PayordInfo> {
	private DaoStmtExecV2<PayordInfo> helper;
	
	
	public DaoPayordUpdate(List<DaoStmtExecOption<PayordInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayordUpdateSingle.class, PayordInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
