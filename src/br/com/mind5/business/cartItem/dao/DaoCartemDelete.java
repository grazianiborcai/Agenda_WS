package br.com.mind5.business.cartItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoCartemDelete implements DaoStmtExecV2<CartemInfo> {
	private DaoStmtExecV2<CartemInfo> helper;
	
	
	public DaoCartemDelete(List<DaoStmtExecOption<CartemInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCartemDeleteSingle.class, CartemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CartemInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
