package br.com.mind5.masterData.dayParting.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;

public final class DaoDaypartSelect implements DaoStmtExecV2<DaypartInfo> {
	private DaoStmtExecV2<DaypartInfo> helper;
	
	
	public DaoDaypartSelect(List<DaoStmtExecOption<DaypartInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoDaypartSelectSingle.class, DaypartInfo.class);
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
