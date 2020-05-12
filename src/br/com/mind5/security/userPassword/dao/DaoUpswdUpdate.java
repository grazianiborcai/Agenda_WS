package br.com.mind5.security.userPassword.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class DaoUpswdUpdate implements DaoStmtExecV2<UpswdInfo> {
	private DaoStmtExecV2<UpswdInfo> helper;
	
	
	public DaoUpswdUpdate(List<DaoStmtExecOption<UpswdInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUpswdUpdateSingle.class, UpswdInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UpswdInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
