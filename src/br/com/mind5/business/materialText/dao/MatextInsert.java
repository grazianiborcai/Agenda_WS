package br.com.mind5.business.materialText.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatextInsert implements DaoStmtExec_<MatextInfo> {
	private DaoStmtExec_<MatextInfo> helper;
	
	
	public MatextInsert(List<DaoStmtExecOption<MatextInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatextInsertSingle.class, MatextInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextInfo> getResultset() {
		return helper.getResultset();
	}
}
