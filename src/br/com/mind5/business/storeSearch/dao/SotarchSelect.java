package br.com.mind5.business.storeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SotarchSelect implements DaoStmtExec_<SotarchInfo> {
	private DaoStmtExec_<SotarchInfo> helper;
	
	
	public SotarchSelect(List<DaoStmtExecOption<SotarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SotarchSelectSingle.class, SotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SotarchInfo> getResultset() {
		return helper.getResultset();
	}
}
