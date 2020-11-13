package br.com.mind5.business.storeTextSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoStorextarchSelect implements DaoStmtExec<StorextarchInfo> {
	private DaoStmtExec<StorextarchInfo> helper;
	
	
	public DaoStorextarchSelect(List<DaoStmtExecOption<StorextarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStorextarchSelectSingle.class, StorextarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorextarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
