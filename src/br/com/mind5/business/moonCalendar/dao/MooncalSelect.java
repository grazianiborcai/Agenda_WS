package br.com.mind5.business.moonCalendar.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MooncalSelect implements DaoStmtExec<MooncalInfo> {
	private DaoStmtExec<MooncalInfo> helper;
	
	
	public MooncalSelect(List<DaoStmtExecOption<MooncalInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MooncalSelectSingle.class, MooncalInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MooncalInfo> getResultset() {
		return helper.getResultset();
	}
}
