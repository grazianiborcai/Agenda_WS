package br.com.mind5.payment.payOrderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class DaoPayordistSelect implements DaoStmtExec<PayordistInfo> {
	private DaoStmtExec<PayordistInfo> helper;
	
	
	public DaoPayordistSelect(List<DaoStmtExecOption<PayordistInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPayordistSelectSingle.class, PayordistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordistInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
