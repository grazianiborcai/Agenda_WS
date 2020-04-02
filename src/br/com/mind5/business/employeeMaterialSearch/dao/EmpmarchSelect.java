package br.com.mind5.business.employeeMaterialSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpmarchSelect implements DaoStmtExec_<EmpmarchInfo> {
	private DaoStmtExec_<EmpmarchInfo> helper;
	
	
	public EmpmarchSelect(List<DaoStmtExecOption<EmpmarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpmarchSelectSingle.class, EmpmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpmarchInfo> getResultset() {
		return helper.getResultset();
	}
}
