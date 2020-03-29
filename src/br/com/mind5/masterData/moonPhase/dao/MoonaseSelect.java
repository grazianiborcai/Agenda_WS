package br.com.mind5.masterData.moonPhase.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MoonaseSelect implements DaoStmtExec<MoonaseInfo> {
	private DaoStmtExec<MoonaseInfo> helper;
	
	
	public MoonaseSelect(List<DaoStmtExecOption<MoonaseInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MoonaseSelectSingle.class, MoonaseInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MoonaseInfo> getResultset() {
		return helper.getResultset();
	}
}
