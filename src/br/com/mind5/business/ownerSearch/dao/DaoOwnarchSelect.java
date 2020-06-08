package br.com.mind5.business.ownerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoOwnarchSelect implements DaoStmtExecV2<OwnarchInfo> {
	private DaoStmtExecV2<OwnarchInfo> helper;
	
	
	public DaoOwnarchSelect(List<DaoStmtExecOption<OwnarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOwnarchSelectSingle.class, OwnarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
