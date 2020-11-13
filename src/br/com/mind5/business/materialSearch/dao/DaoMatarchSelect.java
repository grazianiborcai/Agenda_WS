package br.com.mind5.business.materialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatarchSelect implements DaoStmtExec<MatarchInfo> {
	private DaoStmtExec<MatarchInfo> helper;
	
	
	public DaoMatarchSelect(List<DaoStmtExecOption<MatarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatarchSelectSingle.class, MatarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
