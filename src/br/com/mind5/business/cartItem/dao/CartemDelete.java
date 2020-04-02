package br.com.mind5.business.cartItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CartemDelete implements DaoStmtExec_<CartemInfo> {
	private DaoStmtExec_<CartemInfo> helper;
	
	
	public CartemDelete(List<DaoStmtExecOption<CartemInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CartemDeleteSingle.class, CartemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartemInfo> getResultset() {
		return helper.getResultset();
	}
}
