package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.dao.DaoOrderemUpdate;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemDaoUpdate extends ActionVisitorTemplateStmt<OrderemInfo> {

	public VisiOrderemDaoUpdate(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrderemInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderemInfo>> stmtOptions) {
		return new DaoOrderemUpdate(stmtOptions);
	}
}
