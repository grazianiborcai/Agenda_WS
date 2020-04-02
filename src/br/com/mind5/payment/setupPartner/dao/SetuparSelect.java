package br.com.mind5.payment.setupPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class SetuparSelect implements DaoStmtExec_<SetuparInfo> {
	private DaoStmtExec_<SetuparInfo> helper;
	
	
	public SetuparSelect(List<DaoStmtExecOption<SetuparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SetuparSelectSingle.class, SetuparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SetuparInfo> getResultset() {
		return helper.getResultset();
	}
}
