package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PayparSelect implements DaoStmtExec<PayparInfo> {
	private DaoStmtExec<PayparInfo> helper;
	
	
	public PayparSelect(List<DaoStmtExecOption<PayparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayparSelectSingle.class, PayparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayparInfo> getResultset() {
		return helper.getResultset();
	}
}
