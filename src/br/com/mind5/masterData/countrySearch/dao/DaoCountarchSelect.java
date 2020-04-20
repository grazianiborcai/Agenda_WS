package br.com.mind5.masterData.countrySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;

public final class DaoCountarchSelect implements DaoStmtExecV2<CountarchInfo> {
	private DaoStmtExecV2<CountarchInfo> helper;
	
	
	public DaoCountarchSelect(List<DaoStmtExecOption<CountarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCountarchSelectSingle.class, CountarchInfo.class);
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
