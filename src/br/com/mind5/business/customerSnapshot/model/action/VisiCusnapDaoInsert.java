package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.dao.DaoCusnapInsert;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusnapDaoInsert extends ActionVisitorTemplateStmt<CusnapInfo> {

	public VisiCusnapDaoInsert(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusnapInfo> buildStmtExecHook(List<DaoStmtExecOption<CusnapInfo>> stmtOptions) {
		return new DaoCusnapInsert(stmtOptions);
	}
}
