package br.com.gda.business.cartItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CartUpdateHdr implements DaoStmtExec<CartInfo> {
	private DaoStmtExec<CartInfo> helper;
	
	
	public CartUpdateHdr(List<DaoStmtExecOption<CartInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartUpdateHdrSingle.class, CartInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartInfo> getResultset() {
		return helper.getResultset();
	}
}
