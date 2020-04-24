package br.com.mind5.masterData.dayPartingSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

public final class DaoDayparchSelect implements DaoStmtExecV2<DayparchInfo> {
	private DaoStmtExecV2<DayparchInfo> helper;
	
	
	public DaoDayparchSelect(List<DaoStmtExecOption<DayparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoDayparchSelectSingle.class, DayparchInfo.class);
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
