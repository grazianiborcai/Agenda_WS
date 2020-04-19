package br.com.mind5.business.storeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSotarchSelect implements DaoStmtExecV2<SotarchInfo> {
	private DaoStmtExecV2<SotarchInfo> helper;
	
	
	public DaoSotarchSelect(List<DaoStmtExecOption<SotarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSotarchSelectSingle.class, SotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SotarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
