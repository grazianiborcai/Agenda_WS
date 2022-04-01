package br.com.mind5.business.calendarDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class CalateDaoSelect implements DaoStmtExec<CalateInfo> {
	private DaoStmtExec<CalateInfo> helper;
	
	
	public CalateDaoSelect(List<DaoStmtExecOption<CalateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CalateDaoSelectSingle.class, CalateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<CalateInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();
	}
}
