package br.com.mind5.discount.discountStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public class DisoreDaoSelect implements DaoStmtExec<DisoreInfo> {
	private DaoStmtExec<DisoreInfo> helper;
	
	
	public DisoreDaoSelect(List<DaoStmtExecOption<DisoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DisoreDaoSelectSingle.class, DisoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DisoreInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
