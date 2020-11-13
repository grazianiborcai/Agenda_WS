package br.com.mind5.security.userPassword.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public class DaoUpswdSelect implements DaoStmtExec<UpswdInfo> {
	private DaoStmtExec<UpswdInfo> helper;
	
	
	public DaoUpswdSelect(List<DaoStmtExecOption<UpswdInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoUpswdSelectSingle.class, UpswdInfo.class);
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
