package br.com.mind5.masterData.cartItemCategorySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;

public final class CaritegarchDaoSelect implements DaoStmtExec<CaritegarchInfo> {
	private DaoStmtExec<CaritegarchInfo> helper;
	
	
	public CaritegarchDaoSelect(List<DaoStmtExecOption<CaritegarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CaritegarchDaoSelectSingle.class, CaritegarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CaritegarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
