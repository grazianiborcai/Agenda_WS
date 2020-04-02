package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.CartCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CartCategSelect implements DaoStmtExec_<CartCategInfo> {
	private DaoStmtExec_<CartCategInfo> helper;
	
	
	public CartCategSelect(List<DaoStmtExecOption<CartCategInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CartCategSelectSingle.class, CartCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartCategInfo> getResultset() {
		return helper.getResultset();
	}
}
