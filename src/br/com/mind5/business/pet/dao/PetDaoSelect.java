package br.com.mind5.business.pet.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PetDaoSelect implements DaoStmtExec<PetInfo> {
	private DaoStmtExec<PetInfo> helper;
	
	
	public PetDaoSelect(List<DaoStmtExecOption<PetInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PetDaoSelectSingle.class, PetInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PetInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
