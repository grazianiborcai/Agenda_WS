package br.com.mind5.masterData.materialUnit.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class DaoMatunitSelect implements DaoStmtExecV2<MatunitInfo> {
	private DaoStmtExecV2<MatunitInfo> helper;
	
	
	public DaoMatunitSelect(List<DaoStmtExecOption<MatunitInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatunitSelectSingle.class, MatunitInfo.class);
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
