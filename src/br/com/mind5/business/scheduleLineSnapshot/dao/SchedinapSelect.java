package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class SchedinapSelect implements DaoStmtExec<SchedinapInfo> {
	private DaoStmtExec<SchedinapInfo> helper;
	
	
	public SchedinapSelect(List<DaoStmtExecOption<SchedinapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedinapSelectSingle.class, SchedinapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedinapInfo> getResultset() {
		return helper.getResultset();
	}
}
