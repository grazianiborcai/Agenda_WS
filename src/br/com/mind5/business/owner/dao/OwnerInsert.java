package br.com.mind5.business.owner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OwnerInsert implements DaoStmtExec_<OwnerInfo> {
	private DaoStmtExec_<OwnerInfo> helper;
	
	
	public OwnerInsert(List<DaoStmtExecOption<OwnerInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OwnerInsertSingle.class, OwnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerInfo> getResultset() {
		return helper.getResultset();
	}
}
