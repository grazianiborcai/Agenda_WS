package br.com.mind5.business.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCusDelete implements DaoStmtExecV2<CusInfo> {
	private DaoStmtExecV2<CusInfo> helper;
	
	
	public DaoCusDelete(List<DaoStmtExecOption<CusInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCusDeleteSingle.class, CusInfo.class);
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
