package br.com.mind5.business.addressSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class AddresnapSelect implements DaoStmtExec_<AddresnapInfo> {
	private DaoStmtExec_<AddresnapInfo> helper;
	
	
	public AddresnapSelect(List<DaoStmtExecOption<AddresnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, AddresnapSelectSingle.class, AddresnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddresnapInfo> getResultset() {
		return helper.getResultset();
	}
}
