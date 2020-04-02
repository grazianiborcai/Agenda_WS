package br.com.mind5.masterData.moonPhaseSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MoonasarchSelect implements DaoStmtExec_<MoonasarchInfo> {
	private DaoStmtExec_<MoonasarchInfo> helper;
	
	
	public MoonasarchSelect(List<DaoStmtExecOption<MoonasarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MoonasarchSelectSingle.class, MoonasarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MoonasarchInfo> getResultset() {
		return helper.getResultset();
	}
}
