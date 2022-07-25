package br.com.mind5.masterData.feeCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;

public final class FeecatDaoSelect implements DaoStmtExec<FeecatInfo> {
	private DaoStmtExec<FeecatInfo> helper;
	
	
	public FeecatDaoSelect(List<DaoStmtExecOption<FeecatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeecatDaoSelectSingle.class, FeecatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeecatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
