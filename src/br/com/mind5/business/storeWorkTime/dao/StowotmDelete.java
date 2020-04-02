package br.com.mind5.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StowotmDelete implements DaoStmtExec_<StowotmInfo> {
	private DaoStmtExec_<StowotmInfo> helper;
	
	
	public StowotmDelete(List<DaoStmtExecOption<StowotmInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StowotmDeleteSingle.class, StowotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StowotmInfo> getResultset() {
		return helper.getResultset();
	}
}
