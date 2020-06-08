package br.com.mind5.business.ownerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOwnelisSelect implements DaoStmtExecV2<OwnelisInfo> {
	private DaoStmtExecV2<OwnelisInfo> helper;
	
	
	public DaoOwnelisSelect(List<DaoStmtExecOption<OwnelisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOwnelisSelectSingle.class, OwnelisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnelisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
