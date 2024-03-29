package br.com.mind5.authorization.storeAuthorization.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StorauthDaoSelect implements DaoStmtExec<StorauthInfo> {
	private DaoStmtExec<StorauthInfo> helper;
	
	
	public StorauthDaoSelect(List<DaoStmtExecOption<StorauthInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StorauthDaoSelectSingle.class, StorauthInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorauthInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
