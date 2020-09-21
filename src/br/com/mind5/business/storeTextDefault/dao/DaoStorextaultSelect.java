package br.com.mind5.business.storeTextDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStorextaultSelect implements DaoStmtExecV2<StorextaultInfo> {
	private DaoStmtExecV2<StorextaultInfo> helper;
	
	
	public DaoStorextaultSelect(List<DaoStmtExecOption<StorextaultInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorextaultSelectSingle.class, StorextaultInfo.class);
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
