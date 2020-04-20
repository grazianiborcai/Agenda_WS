package br.com.mind5.masterData.authorizationGroupRole.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public class DaoAuthgroleSelect implements DaoStmtExecV2<AuthgroleInfo> {
	private DaoStmtExecV2<AuthgroleInfo> helper;
	
	
	public DaoAuthgroleSelect(List<DaoStmtExecOption<AuthgroleInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoAuthgroleSelectSingle.class, AuthgroleInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthgroleInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
