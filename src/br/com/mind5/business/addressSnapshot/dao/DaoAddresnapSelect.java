package br.com.mind5.business.addressSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoAddresnapSelect implements DaoStmtExecV2<AddresnapInfo>{
	private DaoStmtExecV2<AddresnapInfo> helper;
	
	
	public DaoAddresnapSelect(List<DaoStmtExecOption<AddresnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoAddresnapSelectSingle.class, AddresnapInfo.class);
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
