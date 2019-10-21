package br.com.mind5.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class StowotmUpdate implements DaoStmtExec<StowotmInfo> {
	private DaoStmtExec<StowotmInfo> helper;
	
	
	public StowotmUpdate(List<DaoStmtExecOption<StowotmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StowotmUpdateSingle.class, StowotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StowotmInfo> getResultset() {
		return helper.getResultset();
	}
}
