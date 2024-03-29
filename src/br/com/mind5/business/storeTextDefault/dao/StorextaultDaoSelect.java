package br.com.mind5.business.storeTextDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StorextaultDaoSelect implements DaoStmtExec<StorextaultInfo> {
	private DaoStmtExec<StorextaultInfo> helper;
	
	
	public StorextaultDaoSelect(List<DaoStmtExecOption<StorextaultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StorextaultDaoSelectSingle.class, StorextaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorextaultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
