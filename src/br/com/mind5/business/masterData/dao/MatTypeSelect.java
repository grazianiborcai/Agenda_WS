package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatTypeSelect implements DaoStmtExec_<MatTypeInfo> {
	private DaoStmtExec_<MatTypeInfo> helper;
	
	
	public MatTypeSelect(List<DaoStmtExecOption<MatTypeInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatTypeSelectSingle.class, MatTypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatTypeInfo> getResultset() {
		return helper.getResultset();
	}
}
