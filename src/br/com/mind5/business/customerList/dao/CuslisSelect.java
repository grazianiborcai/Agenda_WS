package br.com.mind5.business.customerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
