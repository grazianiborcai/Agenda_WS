package br.com.mind5.business.cartItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCartemarchSelect implements DaoStmtExecV2<CartemarchInfo> {
	private DaoStmtExecV2<CartemarchInfo> helper;
	
	
	public DaoCartemarchSelect(List<DaoStmtExecOption<CartemarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCartemarchSelectSingle.class, CartemarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartemarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
