package br.com.mind5.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatoreUpdate implements DaoStmtExecV2<MatoreInfo> {
	private DaoStmtExecV2<MatoreInfo> helper;
	
	
	public DaoMatoreUpdate(List<DaoStmtExecOption<MatoreInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatoreUpdateSingle.class, MatoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatoreInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
