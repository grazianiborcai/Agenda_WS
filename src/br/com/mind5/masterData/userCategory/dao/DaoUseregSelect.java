package br.com.mind5.masterData.userCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.userCategory.info.UseregInfo;

public final class DaoUseregSelect implements DaoStmtExecV2<UseregInfo> {
	private DaoStmtExecV2<UseregInfo> helper;
	
	
	public DaoUseregSelect(List<DaoStmtExecOption<UseregInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUseregSelectSingle.class, UseregInfo.class);
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
