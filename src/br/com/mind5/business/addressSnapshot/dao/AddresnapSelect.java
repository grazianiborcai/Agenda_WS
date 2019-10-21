package br.com.mind5.business.addressSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class AddresnapSelect implements DaoStmtExec<AddresnapInfo> {
	private DaoStmtExec<AddresnapInfo> helper;
	
	
	public AddresnapSelect(List<DaoStmtExecOption<AddresnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AddresnapSelectSingle.class, AddresnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddresnapInfo> getResultset() {
		return helper.getResultset();
	}
}
