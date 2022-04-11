package br.com.mind5.business.orderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class OrdarchDaoSelect implements DaoStmtExec<OrdarchInfo> {
	private DaoStmtExec<OrdarchInfo> helper;
	
	
	public OrdarchDaoSelect(List<DaoStmtExecOption<OrdarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrdarchDaoSelectSingle.class, OrdarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
