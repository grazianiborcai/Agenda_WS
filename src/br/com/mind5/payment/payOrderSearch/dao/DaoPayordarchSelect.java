package br.com.mind5.payment.payOrderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class DaoPayordarchSelect implements DaoStmtExec<PayordarchInfo> {
	private DaoStmtExec<PayordarchInfo> helper;
	
	
	public DaoPayordarchSelect(List<DaoStmtExecOption<PayordarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPayordarchSelectSingle.class, PayordarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
