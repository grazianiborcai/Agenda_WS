package br.com.mind5.discount.discountCouponItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class DisoupemDaoUpdate implements DaoStmtExec<DisoupemInfo> {
	private DaoStmtExec<DisoupemInfo> helper;
	
	
	public DisoupemDaoUpdate(List<DaoStmtExecOption<DisoupemInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DisoupemDaoUpdateSingle.class, DisoupemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DisoupemInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
