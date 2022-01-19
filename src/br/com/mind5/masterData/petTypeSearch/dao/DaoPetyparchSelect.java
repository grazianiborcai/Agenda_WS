package br.com.mind5.masterData.petTypeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;

public final class DaoPetyparchSelect implements DaoStmtExec<PetyparchInfo> {
	private DaoStmtExec<PetyparchInfo> helper;
	
	
	public DaoPetyparchSelect(List<DaoStmtExecOption<PetyparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPetyparchSelectSingle.class, PetyparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PetyparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
