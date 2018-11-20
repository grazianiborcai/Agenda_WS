package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class AreaPhoneSelect implements DaoStmtExec<AreaPhoneInfo> {
	private DaoStmtExec<AreaPhoneInfo> helper;
	
	
	public AreaPhoneSelect(List<DaoStmtExecOption<AreaPhoneInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AreaPhoneSelectSingle.class, AreaPhoneInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AreaPhoneInfo> getResultset() {
		return helper.getResultset();
	}
}
