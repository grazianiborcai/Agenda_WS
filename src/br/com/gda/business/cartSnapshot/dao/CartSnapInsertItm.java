package br.com.gda.business.cartSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CartSnapInsertItm implements DaoStmtExec<CartSnapInfo> {
	private DaoStmtExec<CartSnapInfo> helper;
	
	
	public CartSnapInsertItm(List<DaoStmtExecOption<CartSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartSnapInsertItmSingle.class, CartSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
