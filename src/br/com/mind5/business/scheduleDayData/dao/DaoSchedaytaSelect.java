package br.com.mind5.business.scheduleDayData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoSchedaytaSelect implements DaoStmtExec<SchedaytaInfo> {
	private DaoStmtExec<SchedaytaInfo> helper;
	
	
	public DaoSchedaytaSelect(List<DaoStmtExecOption<SchedaytaInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSchedaytaSelectSingle.class, SchedaytaInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedaytaInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
