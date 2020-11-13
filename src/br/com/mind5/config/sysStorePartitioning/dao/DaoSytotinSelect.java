package br.com.mind5.config.sysStorePartitioning.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;

public final class DaoSytotinSelect implements DaoStmtExec<SytotinInfo> {
	private DaoStmtExec<SytotinInfo> helper;
	
	
	public DaoSytotinSelect(List<DaoStmtExecOption<SytotinInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSytotinSelectSingle.class, SytotinInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SytotinInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
