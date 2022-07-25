package br.com.mind5.masterData.gender.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.gender.info.GenderInfo;

public final class GenderDaoSelect implements DaoStmtExec<GenderInfo> {
	private DaoStmtExec<GenderInfo> helper;
	
	
	public GenderDaoSelect(List<DaoStmtExecOption<GenderInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, GenderDaoSelectSingle.class, GenderInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<GenderInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	@Override public void close() {
		helper.close();		
	}
}
