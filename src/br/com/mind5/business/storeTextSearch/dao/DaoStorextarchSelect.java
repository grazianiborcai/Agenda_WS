package br.com.mind5.business.storeTextSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStorextarchSelect implements DaoStmtExecV2<StorextarchInfo> {
	private DaoStmtExecV2<StorextarchInfo> helper;
	
	
	public DaoStorextarchSelect(List<DaoStmtExecOption<StorextarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorextarchSelectSingle.class, StorextarchInfo.class);
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
