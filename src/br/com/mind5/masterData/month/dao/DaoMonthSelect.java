package br.com.mind5.masterData.month.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.month.info.MonthInfo;

public final class DaoMonthSelect implements DaoStmtExecV2<MonthInfo> {
	private DaoStmtExecV2<MonthInfo> helper;
	
	
	public DaoMonthSelect(List<DaoStmtExecOption<MonthInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMonthSelectSingle.class, MonthInfo.class);
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
