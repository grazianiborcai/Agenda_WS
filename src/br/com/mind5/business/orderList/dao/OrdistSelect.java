package br.com.mind5.business.orderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrdistSelect implements DaoStmtExec_<OrdistInfo> {
	private DaoStmtExec_<OrdistInfo> helper;
	
	
	public OrdistSelect(List<DaoStmtExecOption<OrdistInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrdistSelectSingle.class, OrdistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdistInfo> getResultset() {
		return helper.getResultset();
	}
}
