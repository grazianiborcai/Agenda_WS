package br.com.mind5.masterData.moonPhaseSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;

public final class MoonasarchDaoSelect implements DaoStmtExec<MoonasarchInfo> {
	private DaoStmtExec<MoonasarchInfo> helper;
	
	
	public MoonasarchDaoSelect(List<DaoStmtExecOption<MoonasarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MoonasarchDaoSelectSingle.class, MoonasarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MoonasarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
