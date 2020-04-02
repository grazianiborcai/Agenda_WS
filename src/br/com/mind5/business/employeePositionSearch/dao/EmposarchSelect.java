package br.com.mind5.business.employeePositionSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public class EmposarchSelect implements DaoStmtExec_<EmposarchInfo> {
	private DaoStmtExec_<EmposarchInfo> helper;
	
	
	public EmposarchSelect(List<DaoStmtExecOption<EmposarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmposarchSelectSingle.class, EmposarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmposarchInfo> getResultset() {
		return helper.getResultset();
	}
}
