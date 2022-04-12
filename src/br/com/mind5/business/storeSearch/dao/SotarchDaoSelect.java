package br.com.mind5.business.storeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class SotarchDaoSelect implements DaoStmtExec<SotarchInfo> {
	private DaoStmtExec<SotarchInfo> helper;
	
	
	public SotarchDaoSelect(List<DaoStmtExecOption<SotarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SotarchDaoSelectSingle.class, SotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SotarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
