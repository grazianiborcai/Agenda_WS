package br.com.mind5.business.ownerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOwnerapSelect implements DaoStmtExecV2<OwnerapInfo> {
	private DaoStmtExecV2<OwnerapInfo> helper;
	
	
	public DaoOwnerapSelect(List<DaoStmtExecOption<OwnerapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOwnerapSelectSingle.class, OwnerapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
