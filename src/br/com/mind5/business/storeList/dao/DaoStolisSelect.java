package br.com.mind5.business.storeList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoStolisSelect implements DaoStmtExec<StolisInfo> {
	private DaoStmtExec<StolisInfo> helper;
	
	
	public DaoStolisSelect(List<DaoStmtExecOption<StolisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStolisSelectSingle.class, StolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
