package br.com.mind5.business.storeFavoriteSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;

public class DaoStoritarchSelect implements DaoStmtExecV2<StoritarchInfo> {
	private DaoStmtExecV2<StoritarchInfo> helper;
	
	
	public DaoStoritarchSelect(List<DaoStmtExecOption<StoritarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoritarchSelectSingle.class, StoritarchInfo.class);
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
