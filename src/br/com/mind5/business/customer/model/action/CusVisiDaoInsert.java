package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.dao.CusDaoInsert;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CusVisiDaoInsert extends ActionVisitorTemplateStmt<CusInfo> {

	public CusVisiDaoInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusInfo> buildStmtExecHook(List<DaoStmtExecOption<CusInfo>> stmtOptions) {
		return new CusDaoInsert(stmtOptions);
	}
}
