package br.com.mind5.masterData.businessAreaSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;

public final class BusarearchDaoSelect implements DaoStmtExec<BusarearchInfo> {
	private DaoStmtExec<BusarearchInfo> helper;
	
	
	public BusarearchDaoSelect(List<DaoStmtExecOption<BusarearchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BusarearchDaoSelectSingle.class, BusarearchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BusarearchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
