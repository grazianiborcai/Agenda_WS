package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class PhonapInsert implements DaoStmtExec<PhonapInfo> {
	private DaoStmtExec<PhonapInfo> helper;
	
	
	public PhonapInsert(List<DaoStmtExecOption<PhonapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhonapInsertSingle.class, PhonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonapInfo> getResultset() {
		return helper.getResultset();
	}
}
