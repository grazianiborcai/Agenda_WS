package br.com.mind5.masterData.weekday.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class WeekdayDaoSelect implements DaoStmtExec<WeekdayInfo> {
	private DaoStmtExec<WeekdayInfo> helper;
	
	
	public WeekdayDaoSelect(List<DaoStmtExecOption<WeekdayInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, WeekdayDaoSelectSingle.class, WeekdayInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WeekdayInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
