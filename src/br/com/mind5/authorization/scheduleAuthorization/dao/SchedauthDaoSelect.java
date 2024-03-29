package br.com.mind5.authorization.scheduleAuthorization.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class SchedauthDaoSelect implements DaoStmtExec<SchedauthInfo> {
	private DaoStmtExec<SchedauthInfo> helper;
	
	
	public SchedauthDaoSelect(List<DaoStmtExecOption<SchedauthInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedauthDaoSelectSingle.class, SchedauthInfo.class);
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
