package br.com.mind5.masterData.weekday.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class DaoWeekdaySelect implements DaoStmtExecV2<WeekdayInfo> {
	private DaoStmtExecV2<WeekdayInfo> helper;
	
	
	public DaoWeekdaySelect(List<DaoStmtExecOption<WeekdayInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoWeekdaySelectSingle.class, WeekdayInfo.class);
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
