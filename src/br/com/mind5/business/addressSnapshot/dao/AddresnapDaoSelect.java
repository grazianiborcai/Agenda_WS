package br.com.mind5.business.addressSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class AddresnapDaoSelect implements DaoStmtExec<AddresnapInfo> {
	private DaoStmtExec<AddresnapInfo> helper;
	
	
	public AddresnapDaoSelect(List<DaoStmtExecOption<AddresnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddresnapDaoSelectSingle.class, AddresnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddresnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
