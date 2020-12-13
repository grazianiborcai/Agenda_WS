package br.com.mind5.stats.userStorePurchaseLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.userStorePurchaseLive.info.StusoreveInfo;

public final class DaoStusoreveSelect implements DaoStmtExec<StusoreveInfo> {
	private DaoStmtExec<StusoreveInfo> helper;
	
	
	public DaoStusoreveSelect(List<DaoStmtExecOption<StusoreveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStusoreveSelectSingle.class, StusoreveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusoreveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
