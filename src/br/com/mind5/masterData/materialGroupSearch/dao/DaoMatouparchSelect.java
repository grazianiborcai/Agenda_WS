package br.com.mind5.masterData.materialGroupSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

public final class DaoMatouparchSelect implements DaoStmtExec<MatouparchInfo> {
	private DaoStmtExec<MatouparchInfo> helper;
	
	
	public DaoMatouparchSelect(List<DaoStmtExecOption<MatouparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatouparchSelectSingle.class, MatouparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatouparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
