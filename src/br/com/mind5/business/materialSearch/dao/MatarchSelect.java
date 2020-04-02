package br.com.mind5.business.materialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatarchSelect implements DaoStmtExec_<MatarchInfo> {
	private DaoStmtExec_<MatarchInfo> helper;
	
	
	public MatarchSelect(List<DaoStmtExecOption<MatarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatarchSelectSingle.class, MatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatarchInfo> getResultset() {
		return helper.getResultset();
	}
}
