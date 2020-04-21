package br.com.mind5.business.materialTextDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatextaultSelect implements DaoStmtExecV2<MatextaultInfo> {
	private DaoStmtExecV2<MatextaultInfo> helper;
	
	
	public DaoMatextaultSelect(List<DaoStmtExecOption<MatextaultInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatextaultSelectSingle.class, MatextaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextaultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
