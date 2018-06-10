package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class BusinessSelect implements SqlStmtExec<BusinessInfo> {
	private SqlStmtExec<BusinessInfo> helper;
	
	
	public BusinessSelect(List<SqlStmtExecOption<BusinessInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, BusinessSelectSingle.class, BusinessInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<BusinessInfo> getResultset() {
		return helper.getResultset();
	}
}
