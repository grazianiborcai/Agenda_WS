package br.com.mind5.masterData.materialType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

public final class DaoMatypeSelect implements DaoStmtExec<MatypeInfo> {
	private DaoStmtExec<MatypeInfo> helper;
	
	
	public DaoMatypeSelect(List<DaoStmtExecOption<MatypeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatypeSelectSingle.class, MatypeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatypeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
