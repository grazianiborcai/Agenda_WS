package br.com.mind5.business.orderReserve.model.action;

import java.util.List;

import br.com.mind5.business.orderReserve.dao.OrderveDaoSelect;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderveVisiDaoSelect extends ActionVisitorTemplateStmt<OrderveInfo> {

	public OrderveVisiDaoSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrderveInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderveInfo>> stmtOptions) {
		return new OrderveDaoSelect(stmtOptions);
	}
}
