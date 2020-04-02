package br.com.mind5.business.materialStockSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatocarchSelect implements DaoStmtExec_<MatocarchInfo> {
	private DaoStmtExec_<MatocarchInfo> helper;
	
	
	public MatocarchSelect(List<DaoStmtExecOption<MatocarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatocarchSelectSingle.class, MatocarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatocarchInfo> getResultset() {
		return helper.getResultset();
	}
}
