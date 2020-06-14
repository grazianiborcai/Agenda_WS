package br.com.mind5.business.storeProspect.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStoprosUpdate implements DaoStmtExecV2<StoprosInfo> {
	private DaoStmtExecV2<StoprosInfo> helper;
	
	
	public DaoStoprosUpdate(List<DaoStmtExecOption<StoprosInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoprosUpdateSingle.class, StoprosInfo.class);
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
