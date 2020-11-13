package br.com.mind5.business.orderSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoOrdnapInsert implements DaoStmtExec<OrdnapInfo> {
	private DaoStmtExec<OrdnapInfo> helper;
	
	
	public DaoOrdnapInsert(List<DaoStmtExecOption<OrdnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOrdnapInsertSingle.class, OrdnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
