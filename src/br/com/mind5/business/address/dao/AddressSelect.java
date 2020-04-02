package br.com.mind5.business.address.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class AddressSelect implements DaoStmtExecV2<AddressInfo> {
	private DaoStmtExecV2<AddressInfo> helper;
	
	
	public AddressSelect(List<DaoStmtExecOption<AddressInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, AddressSelectSingle.class, AddressInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddressInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
