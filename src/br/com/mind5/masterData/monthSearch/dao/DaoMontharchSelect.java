package br.com.mind5.masterData.monthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;

public final class DaoMontharchSelect implements DaoStmtExecV2<MontharchInfo> {
	private DaoStmtExecV2<MontharchInfo> helper;
	
	
	public DaoMontharchSelect(List<DaoStmtExecOption<MontharchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMontharchSelectSingle.class, MontharchInfo.class);
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
