package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.dao.DaoOrdemrapSelect;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemrapDaoSelect extends ActionVisitorTemplateStmt<OrdemrapInfo> {

	public VisiOrdemrapDaoSelect(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdemrapInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemrapInfo>> stmtOptions) {
		return new DaoOrdemrapSelect(stmtOptions);
	}
}
