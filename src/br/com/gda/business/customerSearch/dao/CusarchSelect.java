package br.com.gda.business.customerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

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
