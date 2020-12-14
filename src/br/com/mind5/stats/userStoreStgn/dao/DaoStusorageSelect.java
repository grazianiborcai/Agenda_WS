package br.com.mind5.stats.userStoreStgn.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;

public final class DaoStusorageSelect implements DaoStmtExec<StusorageInfo> {
	private DaoStmtExec<StusorageInfo> helper;
	
	
	public DaoStusorageSelect(List<DaoStmtExecOption<StusorageInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStusorageSelectSingle.class, StusorageInfo.class);
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
