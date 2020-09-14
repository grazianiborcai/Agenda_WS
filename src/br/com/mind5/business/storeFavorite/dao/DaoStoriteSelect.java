package br.com.mind5.business.storeFavorite.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public class DaoStoriteSelect implements DaoStmtExecV2<StoriteInfo> {
	private DaoStmtExecV2<StoriteInfo> helper;
	
	
	public DaoStoriteSelect(List<DaoStmtExecOption<StoriteInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoriteSelectSingle.class, StoriteInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoriteInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
