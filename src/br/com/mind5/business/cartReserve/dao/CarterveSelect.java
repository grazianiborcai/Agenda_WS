package br.com.mind5.business.cartReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CarterveSelect implements DaoStmtExec_<CarterveInfo> {
	private DaoStmtExec_<CarterveInfo> helper;
	
	
	public CarterveSelect(List<DaoStmtExecOption<CarterveInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CarterveSelectSingle.class, CarterveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CarterveInfo> getResultset() {
		return helper.getResultset();
	}
}
