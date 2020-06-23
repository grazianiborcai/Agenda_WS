package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedinapInsert implements DaoStmtExecV2<SchedinapInfo> {
	private DaoStmtExecV2<SchedinapInfo> helper;
	
	
	public DaoSchedinapInsert(List<DaoStmtExecOption<SchedinapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSchedinapInsertSingle.class, SchedinapInfo.class);
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
