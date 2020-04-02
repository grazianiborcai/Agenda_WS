package br.com.mind5.business.cartItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CartemarchSelect implements DaoStmtExec_<CartemarchInfo> {
	private DaoStmtExec_<CartemarchInfo> helper;
	
	
	public CartemarchSelect(List<DaoStmtExecOption<CartemarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CartemarchSelectSingle.class, CartemarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartemarchInfo> getResultset() {
		return helper.getResultset();
	}
}
