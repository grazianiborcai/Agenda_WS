package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CartCategInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CartCategSelect implements DaoStmtExec<CartCategInfo> {
	private DaoStmtExec<CartCategInfo> helper;
	
	
	public CartCategSelect(List<DaoStmtExecOption<CartCategInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartCategSelectSingle.class, CartCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartCategInfo> getResultset() {
		return helper.getResultset();
	}
}
