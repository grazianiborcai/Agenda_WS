package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrdemrapSelect implements DaoStmtExecV2<OrdemrapInfo> {
	private DaoStmtExecV2<OrdemrapInfo> helper;
	
	
	public DaoOrdemrapSelect(List<DaoStmtExecOption<OrdemrapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrdemrapSelectSingle.class, OrdemrapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemrapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
