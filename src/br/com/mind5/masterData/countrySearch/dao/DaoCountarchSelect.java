package br.com.mind5.masterData.countrySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;

public final class DaoCountarchSelect implements DaoStmtExec<CountarchInfo> {
	private DaoStmtExec<CountarchInfo> helper;
	
	
	public DaoCountarchSelect(List<DaoStmtExecOption<CountarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCountarchSelectSingle.class, CountarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CountarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
