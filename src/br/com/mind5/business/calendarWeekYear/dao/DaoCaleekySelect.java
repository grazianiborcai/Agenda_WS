package br.com.mind5.business.calendarWeekYear.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCaleekySelect implements DaoStmtExecV2<CaleekyInfo> {
	private DaoStmtExecV2<CaleekyInfo> helper;
	
	
	public DaoCaleekySelect(List<DaoStmtExecOption<CaleekyInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCaleekySelectSingle.class, CaleekyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CaleekyInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
