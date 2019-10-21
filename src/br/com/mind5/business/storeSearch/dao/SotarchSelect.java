package br.com.mind5.business.storeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SotarchSelect implements DaoStmtExec<SotarchInfo> {
	private DaoStmtExec<SotarchInfo> helper;
	
	
	public SotarchSelect(List<DaoStmtExecOption<SotarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SotarchSelectSingle.class, SotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SotarchInfo> getResultset() {
		return helper.getResultset();
	}
}
