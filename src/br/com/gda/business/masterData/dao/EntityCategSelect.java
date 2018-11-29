package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.EntityCategInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EntityCategSelect implements DaoStmtExec<EntityCategInfo> {
	private DaoStmtExec<EntityCategInfo> helper;
	
	
	public EntityCategSelect(List<DaoStmtExecOption<EntityCategInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EntityCategSelectSingle.class, EntityCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EntityCategInfo> getResultset() {
		return helper.getResultset();
	}
}
