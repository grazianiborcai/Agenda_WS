package br.com.mind5.masterData.moonPhase.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

public final class DaoMoonaseSelect implements DaoStmtExecV2<MoonaseInfo> {
	private DaoStmtExecV2<MoonaseInfo> helper;
	
	
	public DaoMoonaseSelect(List<DaoStmtExecOption<MoonaseInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMoonaseSelectSingle.class, MoonaseInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MoonaseInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
