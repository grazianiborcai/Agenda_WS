package br.com.gda.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StowotmInsert implements DaoStmtExec<StowotmInfo> {
	private DaoStmtExec<StowotmInfo> helper;
	
	
	public StowotmInsert(List<DaoStmtExecOption<StowotmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StowotmInsertSingle.class, StowotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StowotmInfo> getResultset() {
		return helper.getResultset();
	}
}
