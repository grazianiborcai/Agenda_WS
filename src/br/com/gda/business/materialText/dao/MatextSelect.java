package br.com.gda.business.materialText.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatextSelect implements DaoStmtExec<MatextInfo> {
	private DaoStmtExec<MatextInfo> helper;
	
	
	public MatextSelect(List<DaoStmtExecOption<MatextInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatextSelectSingle.class, MatextInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextInfo> getResultset() {
		return helper.getResultset();
	}
}
