package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SchedinapInsert implements DaoStmtExec_<SchedinapInfo> {
	private DaoStmtExec_<SchedinapInfo> helper;
	
	
	public SchedinapInsert(List<DaoStmtExecOption<SchedinapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SchedinapInsertSingle.class, SchedinapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedinapInfo> getResultset() {
		return helper.getResultset();
	}
}
