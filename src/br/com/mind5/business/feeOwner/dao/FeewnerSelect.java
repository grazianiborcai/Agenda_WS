package br.com.mind5.business.feeOwner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class FeewnerSelect implements DaoStmtExec_<FeewnerInfo> {
	private DaoStmtExec_<FeewnerInfo> helper;
	
	
	public FeewnerSelect(List<DaoStmtExecOption<FeewnerInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FeewnerSelectSingle.class, FeewnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeewnerInfo> getResultset() {
		return helper.getResultset();
	}
}
