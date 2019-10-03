package br.com.gda.business.ownerStore_.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class OwntoreSelect implements DaoStmtExec<OwntoreInfo> {
	private DaoStmtExec<OwntoreInfo> helper;
	
	
	public OwntoreSelect(List<DaoStmtExecOption<OwntoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OwntoreSelectSingle.class, OwntoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwntoreInfo> getResultset() {
		return helper.getResultset();
	}
}
