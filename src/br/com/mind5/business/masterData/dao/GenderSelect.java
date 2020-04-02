package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class GenderSelect implements DaoStmtExec_<GenderInfo> {
	private DaoStmtExec_<GenderInfo> helper;
	
	
	public GenderSelect(List<DaoStmtExecOption<GenderInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, GenderSelectSingle.class, GenderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<GenderInfo> getResultset() {
		return helper.getResultset();
	}
}
