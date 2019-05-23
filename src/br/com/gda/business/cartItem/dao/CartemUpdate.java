package br.com.gda.business.cartItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CartemUpdate implements DaoStmtExec<CartemInfo> {
	private DaoStmtExec<CartemInfo> helper;
	
	
	public CartemUpdate(List<DaoStmtExecOption<CartemInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartemUpdateSingle.class, CartemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartemInfo> getResultset() {
		return helper.getResultset();
	}
}
