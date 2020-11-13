package br.com.mind5.payment.payOrderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class DaoPayordistSelect implements DaoStmtExecV2<PayordistInfo> {
	private DaoStmtExecV2<PayordistInfo> helper;
	
	
	public DaoPayordistSelect(List<DaoStmtExecOption<PayordistInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayordistSelectSingle.class, PayordistInfo.class);
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
