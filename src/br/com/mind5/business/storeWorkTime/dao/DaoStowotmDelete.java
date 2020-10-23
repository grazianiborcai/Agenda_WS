package br.com.mind5.business.storeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStowotmDelete implements DaoStmtExecV2<StowotmInfo> {
	private DaoStmtExecV2<StowotmInfo> helper;
	
	
	public DaoStowotmDelete(List<DaoStmtExecOption<StowotmInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStowotmDeleteSingle.class, StowotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StowotmInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
