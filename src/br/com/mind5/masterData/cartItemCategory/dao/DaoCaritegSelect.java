package br.com.mind5.masterData.cartItemCategory.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;

public final class DaoCaritegSelect implements DaoStmtExecV2<CaritegInfo> {
	private DaoStmtExecV2<CaritegInfo> helper;
	
	
	public DaoCaritegSelect(List<DaoStmtExecOption<CaritegInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCaritegSelectSingle.class, CaritegInfo.class);
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
