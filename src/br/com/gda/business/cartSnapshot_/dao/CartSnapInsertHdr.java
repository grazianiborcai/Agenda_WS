package br.com.gda.business.cartSnapshot_.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CartSnapInsertHdr implements DaoStmtExec<CartSnapInfo> {
	private DaoStmtExec<CartSnapInfo> helper;
	
	
	public CartSnapInsertHdr(List<DaoStmtExecOption<CartSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartSnapInsertHdrSingle.class, CartSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<CartSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
