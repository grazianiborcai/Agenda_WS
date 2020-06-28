package br.com.mind5.business.companySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoComparchSelect implements DaoStmtExecV2<ComparchInfo> {
	private DaoStmtExecV2<ComparchInfo> helper;
	
	
	public DaoComparchSelect(List<DaoStmtExecOption<ComparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoComparchSelectSingle.class, ComparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ComparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
