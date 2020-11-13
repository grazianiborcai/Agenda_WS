package br.com.mind5.config.sysStoreBusinessContent.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysStoreBusinessContent.info.SytorbcInfo;

public final class DaoSytorbcSelect implements DaoStmtExec<SytorbcInfo> {
	private DaoStmtExec<SytorbcInfo> helper;
	
	
	public DaoSytorbcSelect(List<DaoStmtExecOption<SytorbcInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSytorbcSelectSingle.class, SytorbcInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SytorbcInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
