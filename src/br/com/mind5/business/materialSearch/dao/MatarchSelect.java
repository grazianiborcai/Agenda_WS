package br.com.mind5.business.materialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatarchSelect implements DaoStmtExec<MatarchInfo> {
	private DaoStmtExec<MatarchInfo> helper;
	
	
	public MatarchSelect(List<DaoStmtExecOption<MatarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatarchSelectSingle.class, MatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatarchInfo> getResultset() {
		return helper.getResultset();
	}
}
