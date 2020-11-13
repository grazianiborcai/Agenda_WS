package br.com.mind5.masterData.userCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.userCategory.info.UseregInfo;

public final class DaoUseregSelect implements DaoStmtExec<UseregInfo> {
	private DaoStmtExec<UseregInfo> helper;
	
	
	public DaoUseregSelect(List<DaoStmtExecOption<UseregInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoUseregSelectSingle.class, UseregInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UseregInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
