package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrdemrapSelect implements DaoStmtExec_<OrdemrapInfo> {
	private DaoStmtExec_<OrdemrapInfo> helper;
	
	
	public OrdemrapSelect(List<DaoStmtExecOption<OrdemrapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrdemrapSelectSingle.class, OrdemrapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemrapInfo> getResultset() {
		return helper.getResultset();
	}
}
