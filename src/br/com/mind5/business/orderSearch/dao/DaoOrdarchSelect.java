package br.com.mind5.business.orderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrdarchSelect implements DaoStmtExecV2<OrdarchInfo> {
	private DaoStmtExecV2<OrdarchInfo> helper;
	
	
	public DaoOrdarchSelect(List<DaoStmtExecOption<OrdarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrdarchSelectSingle.class, OrdarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
