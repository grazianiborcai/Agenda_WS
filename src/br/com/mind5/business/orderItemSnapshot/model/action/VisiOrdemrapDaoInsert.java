package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.dao.DaoOrdemrapInsert;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemrapDaoInsert extends ActionVisitorTemplateStmtV2<OrdemrapInfo> {

	public VisiOrdemrapDaoInsert(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrdemrapInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemrapInfo>> stmtOptions) {
		return new DaoOrdemrapInsert(stmtOptions);
	}
}
