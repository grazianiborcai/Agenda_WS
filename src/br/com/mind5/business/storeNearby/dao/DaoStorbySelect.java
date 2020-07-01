package br.com.mind5.business.storeNearby.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStorbySelect implements DaoStmtExecV2<StorbyInfo> {
	private DaoStmtExecV2<StorbyInfo> helper;
	
	
	public DaoStorbySelect(List<DaoStmtExecOption<StorbyInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorbySelectSingle.class, StorbyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorbyInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
