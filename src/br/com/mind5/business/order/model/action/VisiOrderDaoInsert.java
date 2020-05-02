package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.dao.DaoOrderInsert;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderDaoInsert extends ActionVisitorTemplateStmtV2<OrderInfo>{

	public VisiOrderDaoInsert(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrderInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderInfo>> stmtOptions) {
		return new DaoOrderInsert(stmtOptions);
	}
}