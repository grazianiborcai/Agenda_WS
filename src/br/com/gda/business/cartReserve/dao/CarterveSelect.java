package br.com.gda.business.cartReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CarterveSelect implements DaoStmtExec<CarterveInfo> {
	private DaoStmtExec<CarterveInfo> helper;
	
	
	public CarterveSelect(List<DaoStmtExecOption<CarterveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CarterveSelectSingle.class, CarterveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CarterveInfo> getResultset() {
		return helper.getResultset();
	}
}
