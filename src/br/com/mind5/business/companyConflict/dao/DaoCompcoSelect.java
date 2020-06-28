package br.com.mind5.business.companyConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCompcoSelect implements DaoStmtExecV2<CompcoInfo> {
	private DaoStmtExecV2<CompcoInfo> helper;
	
	
	public DaoCompcoSelect(List<DaoStmtExecOption<CompcoInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCompcoSelectSingle.class, CompcoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompcoInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
