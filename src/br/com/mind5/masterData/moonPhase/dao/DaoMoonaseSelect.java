package br.com.mind5.masterData.moonPhase.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

public final class DaoMoonaseSelect implements DaoStmtExec<MoonaseInfo> {
	private DaoStmtExec<MoonaseInfo> helper;
	
	
	public DaoMoonaseSelect(List<DaoStmtExecOption<MoonaseInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMoonaseSelectSingle.class, MoonaseInfo.class);
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
