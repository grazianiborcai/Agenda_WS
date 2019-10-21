package br.com.mind5.business.materialText.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatextSelectDefault implements DaoStmtExec<MatextInfo> {
	private DaoStmtExec<MatextInfo> helper;
	
	
	public MatextSelectDefault(List<DaoStmtExecOption<MatextInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatextSelectSingleDefault.class, MatextInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextInfo> getResultset() {
		return helper.getResultset();
	}
}
