package br.com.mind5.business.materialMovementSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatmarchSelect implements DaoStmtExec<MatmarchInfo> {
	private DaoStmtExec<MatmarchInfo> helper;
	
	
	public MatmarchSelect(List<DaoStmtExecOption<MatmarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatmarchSelectSingle.class, MatmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmarchInfo> getResultset() {
		return helper.getResultset();
	}
}
