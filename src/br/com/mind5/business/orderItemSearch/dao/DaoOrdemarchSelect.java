package br.com.mind5.business.orderItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrdemarchSelect implements DaoStmtExecV2<OrdemarchInfo> {
	private DaoStmtExecV2<OrdemarchInfo> helper;
	
	
	public DaoOrdemarchSelect(List<DaoStmtExecOption<OrdemarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrdemarchSelectSingle.class, OrdemarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
