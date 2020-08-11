package br.com.mind5.security.userPasswordSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public class DaoUpswdarchSelect implements DaoStmtExecV2<UpswdarchInfo> {
	private DaoStmtExecV2<UpswdarchInfo> helper;
	
	
	public DaoUpswdarchSelect(List<DaoStmtExecOption<UpswdarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUpswdarchSelectSingle.class, UpswdarchInfo.class);
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
