package br.com.mind5.business.materialStock.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatockUpdate implements DaoStmtExec_<MatockInfo> {
	private DaoStmtExec_<MatockInfo> helper;
	
	
	public MatockUpdate(List<DaoStmtExecOption<MatockInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatockUpdateSingle.class, MatockInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatockInfo> getResultset() {
		return helper.getResultset();
	}
}
