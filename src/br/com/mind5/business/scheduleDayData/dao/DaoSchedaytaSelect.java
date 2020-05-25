package br.com.mind5.business.scheduleDayData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedaytaSelect implements DaoStmtExecV2<SchedaytaInfo> {
	private DaoStmtExecV2<SchedaytaInfo> helper;
	
	
	public DaoSchedaytaSelect(List<DaoStmtExecOption<SchedaytaInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedaytaSelectSingle.class, SchedaytaInfo.class);
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
