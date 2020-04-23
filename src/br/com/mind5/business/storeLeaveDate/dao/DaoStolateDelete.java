package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStolateDelete implements DaoStmtExecV2<StolateInfo> {
	private DaoStmtExecV2<StolateInfo> helper;
	
	
	public DaoStolateDelete(List<DaoStmtExecOption<StolateInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStolateDeleteSingle.class, StolateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}

	
	
	@Override public List<StolateInfo> getResultset() {
		return helper.getResultset();
	}
}
