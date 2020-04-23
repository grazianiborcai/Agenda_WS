package br.com.mind5.security.storeAuthorization.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class DaoStorauthSelect implements DaoStmtExecV2<StorauthInfo> {
	private DaoStmtExecV2<StorauthInfo> helper;
	
	
	public DaoStorauthSelect(List<DaoStmtExecOption<StorauthInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorauthSelectSingle.class, StorauthInfo.class);
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
