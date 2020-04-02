package br.com.mind5.business.personList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PersolisSelect implements DaoStmtExec_<PersolisInfo> {
	private DaoStmtExec_<PersolisInfo> helper;
	
	
	public PersolisSelect(List<DaoStmtExecOption<PersolisInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PersolisSelectSingle.class, PersolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersolisInfo> getResultset() {
		return helper.getResultset();
	}
}
