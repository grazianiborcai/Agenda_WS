package br.com.mind5.business.personList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PersolisDaoSelect implements DaoStmtExec<PersolisInfo> {
	private DaoStmtExec<PersolisInfo> helper;
	
	
	public PersolisDaoSelect(List<DaoStmtExecOption<PersolisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PersolisDaoSelectSingle.class, PersolisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PersolisInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
