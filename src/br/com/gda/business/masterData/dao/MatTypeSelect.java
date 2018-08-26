package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatTypeSelect implements DaoStmtExec<MatTypeInfo> {
	private DaoStmtExec<MatTypeInfo> helper;
	
	
	public MatTypeSelect(List<DaoStmtExecOption<MatTypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatTypeSelectSingle.class, MatTypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatTypeInfo> getResultset() {
		return helper.getResultset();
	}
}
