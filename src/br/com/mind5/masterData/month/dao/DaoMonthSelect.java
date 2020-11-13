package br.com.mind5.masterData.month.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.month.info.MonthInfo;

public final class DaoMonthSelect implements DaoStmtExec<MonthInfo> {
	private DaoStmtExec<MonthInfo> helper;
	
	
	public DaoMonthSelect(List<DaoStmtExecOption<MonthInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMonthSelectSingle.class, MonthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MonthInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
