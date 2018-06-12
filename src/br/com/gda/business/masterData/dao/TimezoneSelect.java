package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class TimezoneSelect implements SqlStmtExec<TimezoneInfo> {
	private SqlStmtExec<TimezoneInfo> helper;
	
	
	public TimezoneSelect(List<SqlStmtExecOption<TimezoneInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, TimezoneSelectSingle.class, TimezoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<TimezoneInfo> getResultset() {
		return helper.getResultset();
	}
}
