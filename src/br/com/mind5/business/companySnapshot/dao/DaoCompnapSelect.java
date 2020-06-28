package br.com.mind5.business.companySnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCompnapSelect implements DaoStmtExecV2<CompnapInfo> {
	private DaoStmtExecV2<CompnapInfo> helper;
	
	
	public DaoCompnapSelect(List<DaoStmtExecOption<CompnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCompnapSelectSingle.class, CompnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
