package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatTypeSelect implements SqlStmtExec<MatTypeInfo> {
	private SqlStmtExec<MatTypeInfo> helper;
	
	
	public MatTypeSelect(List<SqlStmtExecOption<MatTypeInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatTypeSelectSingle.class, MatTypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatTypeInfo> getResultset() {
		return helper.getResultset();
	}
}
