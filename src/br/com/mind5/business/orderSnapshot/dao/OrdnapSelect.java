package br.com.mind5.business.orderSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class OrdnapSelect implements DaoStmtExec<OrdnapInfo> {
	private DaoStmtExec<OrdnapInfo> helper;
	
	
	public OrdnapSelect(List<DaoStmtExecOption<OrdnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrdnapSelectSingle.class, OrdnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdnapInfo> getResultset() {
		return helper.getResultset();
	}
}
