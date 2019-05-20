package br.com.gda.business.phoneSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PhonapSelect implements DaoStmtExec<PhonapInfo> {
	private DaoStmtExec<PhonapInfo> helper;
	
	
	public PhonapSelect(List<DaoStmtExecOption<PhonapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhonapSelectSingle.class, PhonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonapInfo> getResultset() {
		return helper.getResultset();
	}
}
