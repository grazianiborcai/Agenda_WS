package br.com.mind5.business.materialTextSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatextarchSelect implements DaoStmtExec<MatextarchInfo> {
	private DaoStmtExec<MatextarchInfo> helper;
	
	
	public MatextarchSelect(List<DaoStmtExecOption<MatextarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatextarchSelectSingle.class, MatextarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextarchInfo> getResultset() {
		return helper.getResultset();
	}
}
