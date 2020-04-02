package br.com.mind5.business.personSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PerarchSelect implements DaoStmtExec_<PerarchInfo> {
	private DaoStmtExec_<PerarchInfo> helper;
	
	
	public PerarchSelect(List<DaoStmtExecOption<PerarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PerarchSelectSingle.class, PerarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PerarchInfo> getResultset() {
		return helper.getResultset();
	}
}
