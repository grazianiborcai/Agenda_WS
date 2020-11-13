package br.com.mind5.business.storeFavorite.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.business.storeFavorite.info.StoriteInfo;

public class DaoStoriteSelect implements DaoStmtExec<StoriteInfo> {
	private DaoStmtExec<StoriteInfo> helper;
	
	
	public DaoStoriteSelect(List<DaoStmtExecOption<StoriteInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStoriteSelectSingle.class, StoriteInfo.class);
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
