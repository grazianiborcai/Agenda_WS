package br.com.mind5.business.scheduleWeekData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoSchedeekdatSelect implements DaoStmtExec<SchedeekdatInfo> {
	private DaoStmtExec<SchedeekdatInfo> helper;
	
	
	public DaoSchedeekdatSelect(List<DaoStmtExecOption<SchedeekdatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSchedeekdatSelectSingle.class, SchedeekdatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedeekdatInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();
	}
}
