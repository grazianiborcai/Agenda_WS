package br.com.mind5.business.scheduleWeekData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedeekdatSelect implements DaoStmtExecV2<SchedeekdatInfo> {
	private DaoStmtExecV2<SchedeekdatInfo> helper;
	
	
	public DaoSchedeekdatSelect(List<DaoStmtExecOption<SchedeekdatInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedeekdatSelectSingle.class, SchedeekdatInfo.class);
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
