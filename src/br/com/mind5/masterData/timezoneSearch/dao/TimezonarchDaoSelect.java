package br.com.mind5.masterData.timezoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;

public final class TimezonarchDaoSelect implements DaoStmtExec<TimezonarchInfo> {
	private DaoStmtExec<TimezonarchInfo> helper;
	
	
	public TimezonarchDaoSelect(List<DaoStmtExecOption<TimezonarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, TimezonarchDaoSelectSingle.class, TimezonarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<TimezonarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
