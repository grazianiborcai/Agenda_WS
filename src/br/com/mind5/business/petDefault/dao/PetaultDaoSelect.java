package br.com.mind5.business.petDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PetaultDaoSelect implements DaoStmtExec<PetaultInfo> {
	private DaoStmtExec<PetaultInfo> helper;
	
	
	public PetaultDaoSelect(List<DaoStmtExecOption<PetaultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PetaultSelectDaoSingle.class, PetaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PetaultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
