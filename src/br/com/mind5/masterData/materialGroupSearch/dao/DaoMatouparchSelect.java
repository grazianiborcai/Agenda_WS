package br.com.mind5.masterData.materialGroupSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;

public final class DaoMatouparchSelect implements DaoStmtExecV2<MatouparchInfo> {
	private DaoStmtExecV2<MatouparchInfo> helper;
	
	
	public DaoMatouparchSelect(List<DaoStmtExecOption<MatouparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatouparchSelectSingle.class, MatouparchInfo.class);
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
