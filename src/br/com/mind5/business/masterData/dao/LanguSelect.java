package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class LanguSelect implements DaoStmtExec_<LanguInfo> {
	private DaoStmtExec_<LanguInfo> helper;
	
	
	public LanguSelect(List<DaoStmtExecOption<LanguInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, LanguSelectSingle.class, LanguInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<LanguInfo> getResultset() {
		return helper.getResultset();
	}
}
