package br.com.mind5.masterData.genderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;

public final class DaoGendarchSelect implements DaoStmtExecV2<GendarchInfo> {
	private DaoStmtExecV2<GendarchInfo> helper;
	
	
	public DaoGendarchSelect(List<DaoStmtExecOption<GendarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoGendarchSelectSingle.class, GendarchInfo.class);
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
