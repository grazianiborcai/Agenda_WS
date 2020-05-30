package br.com.mind5.business.calendarDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCalatarchSelect implements DaoStmtExecV2<CalatarchInfo> {
	private DaoStmtExecV2<CalatarchInfo> helper;
	
	
	public DaoCalatarchSelect(List<DaoStmtExecOption<CalatarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCalatarchSelectSingle.class, CalatarchInfo.class);
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
