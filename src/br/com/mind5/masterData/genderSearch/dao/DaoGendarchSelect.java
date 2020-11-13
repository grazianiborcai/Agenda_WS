package br.com.mind5.masterData.genderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;

public final class DaoGendarchSelect implements DaoStmtExec<GendarchInfo> {
	private DaoStmtExec<GendarchInfo> helper;
	
	
	public DaoGendarchSelect(List<DaoStmtExecOption<GendarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoGendarchSelectSingle.class, GendarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<GendarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	@Override public void close() {
		helper.close();		
	}
}
