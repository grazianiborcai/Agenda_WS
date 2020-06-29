package br.com.mind5.business.personSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoPerarchSelect implements DaoStmtExecV2<PerarchInfo> {
	private DaoStmtExecV2<PerarchInfo> helper;
	
	
	public DaoPerarchSelect(List<DaoStmtExecOption<PerarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPerarchSelectSingle.class, PerarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PerarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
