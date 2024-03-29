package br.com.mind5.security.userPasswordSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public class UpswdarchDaoSelect implements DaoStmtExec<UpswdarchInfo> {
	private DaoStmtExec<UpswdarchInfo> helper;
	
	
	public UpswdarchDaoSelect(List<DaoStmtExecOption<UpswdarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UpswdarchDaoSelectSingle.class, UpswdarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UpswdarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
