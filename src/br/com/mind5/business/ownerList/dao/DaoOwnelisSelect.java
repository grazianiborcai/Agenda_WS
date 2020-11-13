package br.com.mind5.business.ownerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoOwnelisSelect implements DaoStmtExec<OwnelisInfo> {
	private DaoStmtExec<OwnelisInfo> helper;
	
	
	public DaoOwnelisSelect(List<DaoStmtExecOption<OwnelisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOwnelisSelectSingle.class, OwnelisInfo.class);
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
