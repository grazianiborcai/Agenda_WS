package br.com.mind5.masterData.dayPartingSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

public final class DaoDayparchSelect implements DaoStmtExec<DayparchInfo> {
	private DaoStmtExec<DayparchInfo> helper;
	
	
	public DaoDayparchSelect(List<DaoStmtExecOption<DayparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoDayparchSelectSingle.class, DayparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DayparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
