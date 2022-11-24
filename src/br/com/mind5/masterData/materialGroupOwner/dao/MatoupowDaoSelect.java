package br.com.mind5.masterData.materialGroupOwner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;

public final class MatoupowDaoSelect implements DaoStmtExec<MatoupowInfo> {
	private DaoStmtExec<MatoupowInfo> helper;
	
	
	public MatoupowDaoSelect(List<DaoStmtExecOption<MatoupowInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatoupowDaoSelectSingle.class, MatoupowInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatoupowInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
