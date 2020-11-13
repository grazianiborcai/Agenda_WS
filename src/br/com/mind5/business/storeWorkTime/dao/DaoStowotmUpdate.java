package br.com.mind5.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoStowotmUpdate implements DaoStmtExec<StowotmInfo> {
	private DaoStmtExec<StowotmInfo> helper;
	
	
	public DaoStowotmUpdate(List<DaoStmtExecOption<StowotmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStowotmUpdateSingle.class, StowotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StowotmInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
