package br.com.mind5.business.orderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class OrdarchSelect implements DaoStmtExec<OrdarchInfo> {
	private DaoStmtExec<OrdarchInfo> helper;
	
	
	public OrdarchSelect(List<DaoStmtExecOption<OrdarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrdarchSelectSingle.class, OrdarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdarchInfo> getResultset() {
		return helper.getResultset();
	}
}
