package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class WeekdaySelect implements SqlStmtExec<WeekdayInfo> {
	private SqlStmtExec<WeekdayInfo> helper;
	
	
	public WeekdaySelect(List<SqlStmtExecOption<WeekdayInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, WeekdaySelectSingle.class, WeekdayInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<WeekdayInfo> getResultset() {
		return helper.getResultset();
	}
}
