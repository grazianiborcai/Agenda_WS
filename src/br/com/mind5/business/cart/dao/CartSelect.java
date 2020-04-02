package br.com.mind5.business.cart.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CartSelect implements DaoStmtExec_<CartInfo> {
	private DaoStmtExec_<CartInfo> helper;
	
	
	public CartSelect(List<DaoStmtExecOption<CartInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CartSelectSingle.class, CartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartInfo> getResultset() {
		return helper.getResultset();
	}
}
