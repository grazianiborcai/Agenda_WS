package br.com.mind5.business.ownerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OwnelisSelect implements DaoStmtExec_<OwnelisInfo> {
	private DaoStmtExec_<OwnelisInfo> helper;
	
	
	public OwnelisSelect(List<DaoStmtExecOption<OwnelisInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OwnelisSelectSingle.class, OwnelisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnelisInfo> getResultset() {
		return helper.getResultset();
	}
}
