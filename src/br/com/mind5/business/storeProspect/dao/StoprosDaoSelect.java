package br.com.mind5.business.storeProspect.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StoprosDaoSelect implements DaoStmtExec<StoprosInfo> {
	private DaoStmtExec<StoprosInfo> helper;
	
	
	public StoprosDaoSelect(List<DaoStmtExecOption<StoprosInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoprosDaoSelectSingle.class, StoprosInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoprosInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
