package br.com.mind5.business.address.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class AddressSelect implements DaoStmtExec_<AddressInfo> {
	private DaoStmtExec_<AddressInfo> helper;
	
	
	public AddressSelect(List<DaoStmtExecOption<AddressInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, AddressSelectSingle.class, AddressInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddressInfo> getResultset() {
		return helper.getResultset();
	}
}
