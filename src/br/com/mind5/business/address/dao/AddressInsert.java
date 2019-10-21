package br.com.mind5.business.address.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class AddressInsert implements DaoStmtExec<AddressInfo> {
	private DaoStmtExec<AddressInfo> helper;
	
	
	public AddressInsert(List<DaoStmtExecOption<AddressInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddressInsertSingle.class, AddressInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddressInfo> getResultset() {
		return helper.getResultset();
	}
}
