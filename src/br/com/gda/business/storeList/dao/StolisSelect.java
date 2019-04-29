package br.com.gda.business.storeList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StolisSelect implements DaoStmtExec<StolisInfo> {
	private DaoStmtExec<StolisInfo> helper;
	
	
	public StolisSelect(List<DaoStmtExecOption<StolisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StolisSelectSingle.class, StolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolisInfo> getResultset() {
		return helper.getResultset();
	}
}
