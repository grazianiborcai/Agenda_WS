package br.com.mind5.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public class StowotmSelectRange implements DaoStmtExec<StowotmInfo> {
	private DaoStmtExec<StowotmInfo> helper;
	
	
	public StowotmSelectRange(List<DaoStmtExecOption<StowotmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StowotmSelectRangeSingle.class, StowotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StowotmInfo> getResultset() {
		return helper.getResultset();
	}
}
