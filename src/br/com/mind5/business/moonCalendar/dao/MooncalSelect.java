package br.com.mind5.business.moonCalendar.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MooncalSelect implements DaoStmtExec_<MooncalInfo> {
	private DaoStmtExec_<MooncalInfo> helper;
	
	
	public MooncalSelect(List<DaoStmtExecOption<MooncalInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MooncalSelectSingle.class, MooncalInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MooncalInfo> getResultset() {
		return helper.getResultset();
	}
}
