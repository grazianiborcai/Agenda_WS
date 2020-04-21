package br.com.mind5.masterData.materialGroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

public final class DaoMatoupSelect implements DaoStmtExecV2<MatoupInfo> {
	private DaoStmtExecV2<MatoupInfo> helper;
	
	
	public DaoMatoupSelect(List<DaoStmtExecOption<MatoupInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatoupSelectSingle.class, MatoupInfo.class);
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
