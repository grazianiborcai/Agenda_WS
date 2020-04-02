package br.com.mind5.business.materialMovement.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatmovSelect implements DaoStmtExec_<MatmovInfo> {
	private DaoStmtExec_<MatmovInfo> helper;
	
	
	public MatmovSelect(List<DaoStmtExecOption<MatmovInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatmovSelectSingle.class, MatmovInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmovInfo> getResultset() {
		return helper.getResultset();
	}
}
