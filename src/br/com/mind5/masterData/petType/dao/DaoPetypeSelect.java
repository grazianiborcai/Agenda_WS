package br.com.mind5.masterData.petType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.petType.info.PetypeInfo;

public final class DaoPetypeSelect implements DaoStmtExec<PetypeInfo> {
	private DaoStmtExec<PetypeInfo> helper;
	
	
	public DaoPetypeSelect(List<DaoStmtExecOption<PetypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPetypeSelectSingle.class, PetypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PetypeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
