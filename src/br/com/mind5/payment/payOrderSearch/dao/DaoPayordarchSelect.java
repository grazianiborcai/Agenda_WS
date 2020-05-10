package br.com.mind5.payment.payOrderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class DaoPayordarchSelect implements DaoStmtExecV2<PayordarchInfo> {
	private DaoStmtExecV2<PayordarchInfo> helper;
	
	
	public DaoPayordarchSelect(List<DaoStmtExecOption<PayordarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayordarchSelectSingle.class, PayordarchInfo.class);
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
