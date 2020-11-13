package br.com.mind5.business.cartReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoCarterveSelect implements DaoStmtExec<CarterveInfo> {
	private DaoStmtExec<CarterveInfo> helper;
	
	
	public DaoCarterveSelect(List<DaoStmtExecOption<CarterveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCarterveSelectSingle.class, CarterveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CarterveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
