package br.com.mind5.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatDelete implements DaoStmtExecV2<MatInfo> {
	private DaoStmtExecV2<MatInfo> helper;
	
	
	public DaoMatDelete(List<DaoStmtExecOption<MatInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatDeleteSingle.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
