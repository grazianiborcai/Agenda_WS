package br.com.mind5.business.petSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPetsnapSelect implements DaoStmtExec<PetsnapInfo> {
	private DaoStmtExec<PetsnapInfo> helper;
	
	
	public DaoPetsnapSelect(List<DaoStmtExecOption<PetsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPetsnapSelectSingle.class, PetsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PetsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
