package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class SchedinapDaoSelect implements DaoStmtExec<SchedinapInfo> {
	private DaoStmtExec<SchedinapInfo> helper;
	
	
	public SchedinapDaoSelect(List<DaoStmtExecOption<SchedinapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchedinapDaoSelectSingle.class, SchedinapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedinapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
