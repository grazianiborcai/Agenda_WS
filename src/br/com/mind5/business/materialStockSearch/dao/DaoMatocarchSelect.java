package br.com.mind5.business.materialStockSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoMatocarchSelect implements DaoStmtExecV2<MatocarchInfo> {
	private DaoStmtExecV2<MatocarchInfo> helper;
	
	
	public DaoMatocarchSelect(List<DaoStmtExecOption<MatocarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoMatocarchSelectSingle.class, MatocarchInfo.class);
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
