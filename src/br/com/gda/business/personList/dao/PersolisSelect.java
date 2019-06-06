package br.com.gda.business.personList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PersolisSelect implements DaoStmtExec<PersolisInfo> {
	private DaoStmtExec<PersolisInfo> helper;
	
	
	public PersolisSelect(List<DaoStmtExecOption<PersolisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PersolisSelectSingle.class, PersolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersolisInfo> getResultset() {
		return helper.getResultset();
	}
}
