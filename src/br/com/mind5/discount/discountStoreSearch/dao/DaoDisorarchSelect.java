package br.com.mind5.discount.discountStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public class DaoDisorarchSelect implements DaoStmtExec<DisorarchInfo> {
	private DaoStmtExec<DisorarchInfo> helper;
	
	
	public DaoDisorarchSelect(List<DaoStmtExecOption<DisorarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoDisorarchSelectSingle.class, DisorarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DisorarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
