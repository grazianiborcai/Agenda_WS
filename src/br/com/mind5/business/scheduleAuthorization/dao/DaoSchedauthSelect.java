package br.com.mind5.business.scheduleAuthorization.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedauthSelect implements DaoStmtExecV2<SchedauthInfo> {
	private DaoStmtExecV2<SchedauthInfo> helper;
	
	
	public DaoSchedauthSelect(List<DaoStmtExecOption<SchedauthInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedauthSelectSingle.class, SchedauthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedauthInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
