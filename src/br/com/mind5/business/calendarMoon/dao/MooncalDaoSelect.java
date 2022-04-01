package br.com.mind5.business.calendarMoon.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class MooncalDaoSelect implements DaoStmtExec<MooncalInfo> {
	private DaoStmtExec<MooncalInfo> helper;
	
	
	public MooncalDaoSelect(List<DaoStmtExecOption<MooncalInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MooncalDaoSelectSingle.class, MooncalInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MooncalInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
