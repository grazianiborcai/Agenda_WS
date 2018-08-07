package br.com.gda.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public class StoreWTimeSelectRange implements DaoStmtExec<StoreWTimeInfo> {
	private DaoStmtExec<StoreWTimeInfo> helper;
	
	
	public StoreWTimeSelectRange(List<DaoStmtExecOption<StoreWTimeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreWTimeSelectRangeSingle.class, StoreWTimeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreWTimeInfo> getResultset() {
		return helper.getResultset();
	}
}
