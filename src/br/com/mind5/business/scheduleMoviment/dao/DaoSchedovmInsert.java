package br.com.mind5.business.scheduleMoviment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSchedovmInsert implements DaoStmtExecV2<SchedovmInfo> {
	private DaoStmtExecV2<SchedovmInfo> helper;
	
	
	public DaoSchedovmInsert(List<DaoStmtExecOption<SchedovmInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, SchedovmInsertSingle.class, SchedovmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchedovmInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
