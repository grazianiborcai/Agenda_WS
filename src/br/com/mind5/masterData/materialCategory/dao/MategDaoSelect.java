package br.com.mind5.masterData.materialCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialCategory.info.MategInfo;

public final class MategDaoSelect implements DaoStmtExec<MategInfo> {
	private DaoStmtExec<MategInfo> helper;
	
	
	public MategDaoSelect(List<DaoStmtExecOption<MategInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MategDaoSelectSingle.class, MategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MategInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
