package br.com.mind5.business.storeText.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoStorextSelect implements DaoStmtExecV2<StorextInfo> {
	private DaoStmtExecV2<StorextInfo> helper;
	
	
	public DaoStorextSelect(List<DaoStmtExecOption<StorextInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStorextSelectSingle.class, StorextInfo.class);
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
