package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PhonapInsert implements DaoStmtExec_<PhonapInfo> {
	private DaoStmtExec_<PhonapInfo> helper;
	
	
	public PhonapInsert(List<DaoStmtExecOption<PhonapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PhonapInsertSingle.class, PhonapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonapInfo> getResultset() {
		return helper.getResultset();
	}
}
