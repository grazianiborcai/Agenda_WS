package br.com.mind5.masterData.materialType.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialType.info.MatypeInfo;

public final class DaoMatypeSelect implements DaoStmtExecV2<MatypeInfo> {
	private DaoStmtExecV2<MatypeInfo> helper;
	
	
	public DaoMatypeSelect(List<DaoStmtExecOption<MatypeInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatypeSelectSingle.class, MatypeInfo.class);
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
