package br.com.mind5.business.ownerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OwnerapInsert implements DaoStmtExec_<OwnerapInfo> {
	private DaoStmtExec_<OwnerapInfo> helper;
	
	
	public OwnerapInsert(List<DaoStmtExecOption<OwnerapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OwnerapInsertSingle.class, OwnerapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerapInfo> getResultset() {
		return helper.getResultset();
	}
}
