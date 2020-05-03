package br.com.mind5.business.orderSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOrdnapInsert implements DaoStmtExecV2<OrdnapInfo> {
	private DaoStmtExecV2<OrdnapInfo> helper;
	
	
	public DaoOrdnapInsert(List<DaoStmtExecOption<OrdnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOrdnapInsertSingle.class, OrdnapInfo.class);
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
