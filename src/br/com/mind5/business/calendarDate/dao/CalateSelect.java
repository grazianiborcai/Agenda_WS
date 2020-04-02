package br.com.mind5.business.calendarDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CalateSelect implements DaoStmtExec_<CalateInfo> {
	private DaoStmtExec_<CalateInfo> helper;
	
	
	public CalateSelect(List<DaoStmtExecOption<CalateInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CalateSelectSingle.class, CalateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CalateInfo> getResultset() {
		return helper.getResultset();
	}
}
