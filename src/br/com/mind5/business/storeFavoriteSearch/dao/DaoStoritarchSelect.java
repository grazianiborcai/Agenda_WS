package br.com.mind5.business.storeFavoriteSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

public class DaoStoritarchSelect implements DaoStmtExec<StoritarchInfo> {
	private DaoStmtExec<StoritarchInfo> helper;
	
	
	public DaoStoritarchSelect(List<DaoStmtExecOption<StoritarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStoritarchSelectSingle.class, StoritarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoritarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
