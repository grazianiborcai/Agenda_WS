package br.com.gda.business.owner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OwnerDelete implements DaoStmtExec<OwnerInfo> {
	private DaoStmtExec<OwnerInfo> helper;
	
	
	public OwnerDelete(List<DaoStmtExecOption<OwnerInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OwnerDeleteSingle.class, OwnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerInfo> getResultset() {
		return helper.getResultset();
	}
}
