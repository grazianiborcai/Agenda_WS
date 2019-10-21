package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
