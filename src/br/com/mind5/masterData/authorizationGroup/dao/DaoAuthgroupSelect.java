package br.com.mind5.masterData.authorizationGroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;

public class DaoAuthgroupSelect implements DaoStmtExecV2<AuthgroupInfo> {
	private DaoStmtExecV2<AuthgroupInfo> helper;
	
	
	public DaoAuthgroupSelect(List<DaoStmtExecOption<AuthgroupInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoAuthgroupSelectSingle.class, AuthgroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthgroupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
