package br.com.mind5.business.materialMovementSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatmarchSelect implements DaoStmtExecV2<MatmarchInfo> {
	private DaoStmtExecV2<MatmarchInfo> helper;
	
	
	public DaoMatmarchSelect(List<DaoStmtExecOption<MatmarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatmarchSelectSingle.class, MatmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
