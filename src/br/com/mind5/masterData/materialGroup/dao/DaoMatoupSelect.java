package br.com.mind5.masterData.materialGroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

public final class DaoMatoupSelect implements DaoStmtExec<MatoupInfo> {
	private DaoStmtExec<MatoupInfo> helper;
	
	
	public DaoMatoupSelect(List<DaoStmtExecOption<MatoupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatoupSelectSingle.class, MatoupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatoupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
