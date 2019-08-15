package br.com.gda.business.customerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CuslisSelect implements DaoStmtExec<CuslisInfo> {
	private DaoStmtExec<CuslisInfo> helper;
	
	
	public CuslisSelect(List<DaoStmtExecOption<CuslisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CuslisSelectSingle.class, CuslisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CuslisInfo> getResultset() {
		return helper.getResultset();
	}
}
