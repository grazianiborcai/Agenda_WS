package br.com.mind5.business.ownerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class OwnarchDaoSelect implements DaoStmtExec<OwnarchInfo> {
	private DaoStmtExec<OwnarchInfo> helper;
	
	
	public OwnarchDaoSelect(List<DaoStmtExecOption<OwnarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OwnarchDaoSelectSingle.class, OwnarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
