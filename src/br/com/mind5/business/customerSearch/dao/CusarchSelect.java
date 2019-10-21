package br.com.mind5.business.customerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CusarchSelect implements DaoStmtExec<CusarchInfo> {
	private DaoStmtExec<CusarchInfo> helper;
	
	
	public CusarchSelect(List<DaoStmtExecOption<CusarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusarchSelectSingle.class, CusarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusarchInfo> getResultset() {
		return helper.getResultset();
	}
}
