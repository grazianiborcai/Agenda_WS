package br.com.mind5.business.addressSnapshotSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoAddresnaparchSelect implements DaoStmtExec<AddresnaparchInfo> {
	private DaoStmtExec<AddresnaparchInfo> helper;
	
	
	public DaoAddresnaparchSelect(List<DaoStmtExecOption<AddresnaparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoAddresnaparchSelectSingle.class, AddresnaparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<AddresnaparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
