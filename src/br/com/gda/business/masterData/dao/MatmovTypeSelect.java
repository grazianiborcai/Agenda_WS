package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatmovTypeSelect implements DaoStmtExec<MatmovTypeInfo> {
	private DaoStmtExec<MatmovTypeInfo> helper;
	
	
	public MatmovTypeSelect(List<DaoStmtExecOption<MatmovTypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatmovTypeSelectSingle.class, MatmovTypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmovTypeInfo> getResultset() {
		return helper.getResultset();
	}
}
