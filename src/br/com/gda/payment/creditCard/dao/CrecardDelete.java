package br.com.gda.payment.creditCard.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CrecardDelete implements DaoStmtExec<CrecardInfo> {
	private DaoStmtExec<CrecardInfo> helper;
	
	
	public CrecardDelete(List<DaoStmtExecOption<CrecardInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CrecardDeleteSingle.class, CrecardInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CrecardInfo> getResultset() {
		return helper.getResultset();
	}
}
