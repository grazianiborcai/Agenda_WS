package br.com.mind5.masterData.discountStrategy.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;

public final class DaoDisegySelect implements DaoStmtExec<DisegyInfo> {
	private DaoStmtExec<DisegyInfo> helper;
	
	
	public DaoDisegySelect(List<DaoStmtExecOption<DisegyInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoDisegySelectSingle.class, DisegyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DisegyInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
