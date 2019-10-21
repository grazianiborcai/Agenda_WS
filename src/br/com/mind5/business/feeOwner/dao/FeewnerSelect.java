package br.com.mind5.business.feeOwner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class FeewnerSelect implements DaoStmtExec<FeewnerInfo> {
	private DaoStmtExec<FeewnerInfo> helper;
	
	
	public FeewnerSelect(List<DaoStmtExecOption<FeewnerInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeewnerSelectSingle.class, FeewnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeewnerInfo> getResultset() {
		return helper.getResultset();
	}
}
