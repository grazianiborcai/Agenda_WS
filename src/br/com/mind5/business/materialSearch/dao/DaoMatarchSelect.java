package br.com.mind5.business.materialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatarchSelect implements DaoStmtExecV2<MatarchInfo> {
	private DaoStmtExecV2<MatarchInfo> helper;
	
	
	public DaoMatarchSelect(List<DaoStmtExecOption<MatarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatarchSelectSingle.class, MatarchInfo.class);
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
