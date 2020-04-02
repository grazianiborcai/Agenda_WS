package br.com.mind5.business.orderSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class OrdnapInsert implements DaoStmtExec_<OrdnapInfo> {
	private DaoStmtExec_<OrdnapInfo> helper;
	
	
	public OrdnapInsert(List<DaoStmtExecOption<OrdnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OrdnapInsertSingle.class, OrdnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<OrdnapInfo> getResultset() {
		return helper.getResultset();
	}
}
