package br.com.mind5.masterData.cartItemCategorySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;

public final class DaoCaritegarchSelect implements DaoStmtExecV2<CaritegarchInfo> {
	private DaoStmtExecV2<CaritegarchInfo> helper;
	
	
	public DaoCaritegarchSelect(List<DaoStmtExecOption<CaritegarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCaritegarchSelectSingle.class, CaritegarchInfo.class);
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
