package br.com.mind5.masterData.weekdaySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;

public final class DaoWeekdarchSelect implements DaoStmtExec<WeekdarchInfo> {
	private DaoStmtExec<WeekdarchInfo> helper;
	
	
	public DaoWeekdarchSelect(List<DaoStmtExecOption<WeekdarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoWeekdarchSelectSingle.class, WeekdarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WeekdarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
