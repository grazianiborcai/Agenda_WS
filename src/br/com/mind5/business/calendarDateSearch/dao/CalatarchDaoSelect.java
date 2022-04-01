package br.com.mind5.business.calendarDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class CalatarchDaoSelect implements DaoStmtExec<CalatarchInfo> {
	private DaoStmtExec<CalatarchInfo> helper;
	
	
	public CalatarchDaoSelect(List<DaoStmtExecOption<CalatarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CalatarchDaoSelectSingle.class, CalatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CalatarchInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
