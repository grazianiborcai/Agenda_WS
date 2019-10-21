package br.com.mind5.security.storeAuthorization.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthSelect implements DaoStmtExec<StorauthInfo> {
	private DaoStmtExec<StorauthInfo> helper;
	
	
	public StorauthSelect(List<DaoStmtExecOption<StorauthInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StorauthSelectSingle.class, StorauthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorauthInfo> getResultset() {
		return helper.getResultset();
	}
}
