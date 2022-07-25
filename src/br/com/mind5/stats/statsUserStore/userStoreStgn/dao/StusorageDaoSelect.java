package br.com.mind5.stats.statsUserStore.userStoreStgn.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;

public final class StusorageDaoSelect implements DaoStmtExec<StusorageInfo> {
	private DaoStmtExec<StusorageInfo> helper;
	
	
	public StusorageDaoSelect(List<DaoStmtExecOption<StusorageInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StusorageDaoSelectSingle.class, StusorageInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusorageInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
