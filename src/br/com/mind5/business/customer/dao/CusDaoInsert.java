package br.com.mind5.business.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class CusDaoInsert implements DaoStmtExec<CusInfo> {
	private DaoStmtExec<CusInfo> helper;
	
	
	public CusDaoInsert(List<DaoStmtExecOption<CusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusDaoInsertSingle.class, CusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
