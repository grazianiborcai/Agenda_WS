package br.com.mind5.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatsnapSelect implements DaoStmtExec<MatsnapInfo> {
	private DaoStmtExec<MatsnapInfo> helper;
	
	
	public MatsnapSelect(List<DaoStmtExecOption<MatsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatsnapSelectSingle.class, MatsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatsnapInfo> getResultset() {
		return helper.getResultset();
	}
}
