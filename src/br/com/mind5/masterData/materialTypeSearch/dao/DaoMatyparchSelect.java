package br.com.mind5.masterData.materialTypeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;

public final class DaoMatyparchSelect implements DaoStmtExec<MatyparchInfo> {
	private DaoStmtExec<MatyparchInfo> helper;
	
	
	public DaoMatyparchSelect(List<DaoStmtExecOption<MatyparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatyparchSelectSingle.class, MatyparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatyparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
