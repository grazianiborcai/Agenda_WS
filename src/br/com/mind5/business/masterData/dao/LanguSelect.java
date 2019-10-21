package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class LanguSelect implements DaoStmtExec<LanguInfo> {
	private DaoStmtExec<LanguInfo> helper;
	
	
	public LanguSelect(List<DaoStmtExecOption<LanguInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, LanguSelectSingle.class, LanguInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<LanguInfo> getResultset() {
		return helper.getResultset();
	}
}
