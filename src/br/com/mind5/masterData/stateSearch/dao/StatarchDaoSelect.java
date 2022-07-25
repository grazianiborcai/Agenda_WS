package br.com.mind5.masterData.stateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;

public final class StatarchDaoSelect implements DaoStmtExec<StatarchInfo> {
	private DaoStmtExec<StatarchInfo> helper;
	
	
	public StatarchDaoSelect(List<DaoStmtExecOption<StatarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StatarchDaoSelectSingle.class, StatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StatarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
