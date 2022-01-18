package br.com.mind5.masterData.petTypeSeach.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;

public final class DaoMontharchSelect implements DaoStmtExec<MontharchInfo> {
	private DaoStmtExec<MontharchInfo> helper;
	
	
	public DaoMontharchSelect(List<DaoStmtExecOption<MontharchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMontharchSelectSingle.class, MontharchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MontharchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
