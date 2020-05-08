package br.com.mind5.masterData.paymentStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;

public final class DaoPaymenusSelect implements DaoStmtExecV2<PaymenusInfo> {
	private DaoStmtExecV2<PaymenusInfo> helper;
	
	
	public DaoPaymenusSelect(List<DaoStmtExecOption<PaymenusInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPaymenusSelectSingle.class, PaymenusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaymenusInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
