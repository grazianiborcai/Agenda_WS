package br.com.mind5.business.calendarDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CalateSelect implements DaoStmtExec<CalateInfo> {
	private DaoStmtExec<CalateInfo> helper;
	
	
	public CalateSelect(List<DaoStmtExecOption<CalateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CalateSelectSingle.class, CalateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CalateInfo> getResultset() {
		return helper.getResultset();
	}
}
