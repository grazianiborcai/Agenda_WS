package br.com.mind5.business.owner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class OwnerUpdate implements DaoStmtExec<OwnerInfo> {
	private DaoStmtExec<OwnerInfo> helper;
	
	
	public OwnerUpdate(List<DaoStmtExecOption<OwnerInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OwnerUpdateSingle.class, OwnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerInfo> getResultset() {
		return helper.getResultset();
	}
}
