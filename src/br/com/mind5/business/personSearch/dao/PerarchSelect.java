package br.com.mind5.business.personSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class PerarchSelect implements DaoStmtExec<PerarchInfo> {
	private DaoStmtExec<PerarchInfo> helper;
	
	
	public PerarchSelect(List<DaoStmtExecOption<PerarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PerarchSelectSingle.class, PerarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PerarchInfo> getResultset() {
		return helper.getResultset();
	}
}
