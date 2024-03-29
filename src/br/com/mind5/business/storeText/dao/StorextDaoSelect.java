package br.com.mind5.business.storeText.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StorextDaoSelect implements DaoStmtExec<StorextInfo> {
	private DaoStmtExec<StorextInfo> helper;
	
	
	public StorextDaoSelect(List<DaoStmtExecOption<StorextInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StorextDaoSelectSingle.class, StorextInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorextInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
