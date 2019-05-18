package br.com.gda.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatsnapSelect implements DaoStmtExec<MatsnapInfo> {
	private DaoStmtExec<MatsnapInfo> helper;
	
	
	public MatsnapSelect(List<DaoStmtExecOption<MatsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatsnapSelectSingle.class, MatsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatsnapInfo> getResultset() {
		return helper.getResultset();
	}
}
