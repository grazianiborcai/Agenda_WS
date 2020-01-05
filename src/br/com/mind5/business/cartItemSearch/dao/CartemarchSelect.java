package br.com.mind5.business.cartItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CartemarchSelect implements DaoStmtExec<CartemarchInfo> {
	private DaoStmtExec<CartemarchInfo> helper;
	
	
	public CartemarchSelect(List<DaoStmtExecOption<CartemarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CartemarchSelectSingle.class, CartemarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartemarchInfo> getResultset() {
		return helper.getResultset();
	}
}
