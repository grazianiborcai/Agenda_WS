package br.com.mind5.business.cart.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCartUpdate implements DaoStmtExecV2<CartInfo> {
	private DaoStmtExecV2<CartInfo> helper;
	
	
	public DaoCartUpdate(List<DaoStmtExecOption<CartInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCartUpdateSingle.class, CartInfo.class);
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
