package br.com.mind5.business.storeProspectSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StoprarchDaoSelect implements DaoStmtExec<StoprarchInfo> {
	private DaoStmtExec<StoprarchInfo> helper;
	
	
	public StoprarchDaoSelect(List<DaoStmtExecOption<StoprarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoprarchDaoSelectSingle.class, StoprarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoprarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
