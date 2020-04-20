package br.com.mind5.masterData.moonPhaseSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;

public final class DaoMoonasarchSelect implements DaoStmtExecV2<MoonasarchInfo> {
	private DaoStmtExecV2<MoonasarchInfo> helper;
	
	
	public DaoMoonasarchSelect(List<DaoStmtExecOption<MoonasarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMoonasarchSelectSingle.class, MoonasarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MoonasarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
