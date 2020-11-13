package br.com.mind5.business.materialTextSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatextarchSelect implements DaoStmtExec<MatextarchInfo> {
	private DaoStmtExec<MatextarchInfo> helper;
	
	
	public DaoMatextarchSelect(List<DaoStmtExecOption<MatextarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatextarchSelectSingle.class, MatextarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
