package br.com.mind5.business.materialMovementSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatmarchSelect implements DaoStmtExec_<MatmarchInfo> {
	private DaoStmtExec_<MatmarchInfo> helper;
	
	
	public MatmarchSelect(List<DaoStmtExecOption<MatmarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatmarchSelectSingle.class, MatmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmarchInfo> getResultset() {
		return helper.getResultset();
	}
}
