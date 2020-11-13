package br.com.mind5.business.cart.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoCartDelete implements DaoStmtExec<CartInfo> {
	private DaoStmtExec<CartInfo> helper;
	
	
	public DaoCartDelete(List<DaoStmtExecOption<CartInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCartDeleteSingle.class, CartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
