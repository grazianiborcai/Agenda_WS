package br.com.mind5.masterData.cartItemCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;

public final class CaritegDaoSelect implements DaoStmtExec<CaritegInfo> {
	private DaoStmtExec<CaritegInfo> helper;
	
	
	public CaritegDaoSelect(List<DaoStmtExecOption<CaritegInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CaritegDaoSelectSingle.class, CaritegInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CaritegInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
