package br.com.mind5.business.materialStockSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class MatocarchDaoSelect implements DaoStmtExec<MatocarchInfo> {
	private DaoStmtExec<MatocarchInfo> helper;
	
	
	public MatocarchDaoSelect(List<DaoStmtExecOption<MatocarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatocarchDaoSelectSingle.class, MatocarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatocarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
