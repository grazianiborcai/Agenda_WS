package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatmovTypeSelect implements DaoStmtExec_<MatmovTypeInfo> {
	private DaoStmtExec_<MatmovTypeInfo> helper;
	
	
	public MatmovTypeSelect(List<DaoStmtExecOption<MatmovTypeInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatmovTypeSelectSingle.class, MatmovTypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmovTypeInfo> getResultset() {
		return helper.getResultset();
	}
}
