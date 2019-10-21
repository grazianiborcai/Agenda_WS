package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MonthSelect implements DaoStmtExec<MonthInfo> {
	private DaoStmtExec<MonthInfo> helper;
	
	
	public MonthSelect(List<DaoStmtExecOption<MonthInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MonthSelectSingle.class, MonthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MonthInfo> getResultset() {
		return helper.getResultset();
	}
}
