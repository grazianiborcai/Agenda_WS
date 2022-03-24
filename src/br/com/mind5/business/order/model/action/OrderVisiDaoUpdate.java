package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.dao.OrderDaoUpdate;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiDaoUpdate extends ActionVisitorTemplateStmt<OrderInfo> {

	public OrderVisiDaoUpdate(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrderInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderInfo>> stmtOptions) {
		return new OrderDaoUpdate(stmtOptions);
	}
}
