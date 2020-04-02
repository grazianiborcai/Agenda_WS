package br.com.mind5.masterData.moonPhase.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MoonaseSelect implements DaoStmtExec_<MoonaseInfo> {
	private DaoStmtExec_<MoonaseInfo> helper;
	
	
	public MoonaseSelect(List<DaoStmtExecOption<MoonaseInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MoonaseSelectSingle.class, MoonaseInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MoonaseInfo> getResultset() {
		return helper.getResultset();
	}
}
