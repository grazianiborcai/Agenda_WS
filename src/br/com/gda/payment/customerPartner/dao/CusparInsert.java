package br.com.gda.payment.customerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparInsert implements DaoStmtExec<CusparInfo> {
	private DaoStmtExec<CusparInfo> helper;
	
	
	public CusparInsert(List<DaoStmtExecOption<CusparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusparInsertSingle.class, CusparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<CusparInfo> getResultset() {
		return helper.getResultset();
	}
}
