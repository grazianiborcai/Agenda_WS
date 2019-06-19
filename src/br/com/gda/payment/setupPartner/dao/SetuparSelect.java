package br.com.gda.payment.setupPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class SetuparSelect implements DaoStmtExec<SetuparInfo> {
	private DaoStmtExec<SetuparInfo> helper;
	
	
	public SetuparSelect(List<DaoStmtExecOption<SetuparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SetuparSelectSingle.class, SetuparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SetuparInfo> getResultset() {
		return helper.getResultset();
	}
}
