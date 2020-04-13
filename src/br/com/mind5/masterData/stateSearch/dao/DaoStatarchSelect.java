package br.com.mind5.masterData.stateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;

public final class DaoStatarchSelect implements DaoStmtExecV2<StatarchInfo> {
	private DaoStmtExecV2<StatarchInfo> helper;
	
	
	public DaoStatarchSelect(List<DaoStmtExecOption<StatarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStatarchSelectSingle.class, StatarchInfo.class);
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
