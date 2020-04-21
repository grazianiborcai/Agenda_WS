package br.com.mind5.business.materialText.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatextDelete implements DaoStmtExecV2<MatextInfo> {
	private DaoStmtExecV2<MatextInfo> helper;
	
	
	public DaoMatextDelete(List<DaoStmtExecOption<MatextInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatextDeleteSingle.class, MatextInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
