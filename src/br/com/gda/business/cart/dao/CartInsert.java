package br.com.gda.business.cart.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CartInsert implements DaoStmtExec<CartInfo> {
	private DaoStmtExec<CartInfo> helper;
	
	
	public CartInsert(List<DaoStmtExecOption<CartInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartInsertSingle.class, CartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<CartInfo> getResultset() {
		return helper.getResultset();
	}
}
