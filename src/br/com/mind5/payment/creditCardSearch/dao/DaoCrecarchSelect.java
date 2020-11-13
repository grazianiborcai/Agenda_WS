package br.com.mind5.payment.creditCardSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class DaoCrecarchSelect implements DaoStmtExecV2<CrecarchInfo> {
	private DaoStmtExecV2<CrecarchInfo> helper;
	
	
	public DaoCrecarchSelect(List<DaoStmtExecOption<CrecarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoCrecarchSelectSingle.class, CrecarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CrecarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
