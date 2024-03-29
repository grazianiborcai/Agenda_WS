package br.com.mind5.masterData.dayParting.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;

public final class DaypartDaoSelect implements DaoStmtExec<DaypartInfo> {
	private DaoStmtExec<DaypartInfo> helper;
	
	
	public DaypartDaoSelect(List<DaoStmtExecOption<DaypartInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaypartDaoSelectSingle.class, DaypartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DaypartInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
