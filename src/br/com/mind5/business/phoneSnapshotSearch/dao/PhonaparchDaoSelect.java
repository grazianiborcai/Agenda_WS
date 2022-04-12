package br.com.mind5.business.phoneSnapshotSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PhonaparchDaoSelect implements DaoStmtExec<PhonaparchInfo> {
	private DaoStmtExec<PhonaparchInfo> helper;
	
	
	public PhonaparchDaoSelect(List<DaoStmtExecOption<PhonaparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhonaparchDaoSelectSingle.class, PhonaparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonaparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
