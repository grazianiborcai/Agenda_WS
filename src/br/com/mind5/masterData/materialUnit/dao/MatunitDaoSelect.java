package br.com.mind5.masterData.materialUnit.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class MatunitDaoSelect implements DaoStmtExec<MatunitInfo> {
	private DaoStmtExec<MatunitInfo> helper;
	
	
	public MatunitDaoSelect(List<DaoStmtExecOption<MatunitInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatunitDaoSelectSingle.class, MatunitInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatunitInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
