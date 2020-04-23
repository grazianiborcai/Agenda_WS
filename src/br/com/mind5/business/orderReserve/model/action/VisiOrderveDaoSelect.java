package br.com.mind5.business.orderReserve.model.action;

import java.util.List;

import br.com.mind5.business.orderReserve.dao.DaoOrderveSelect;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderveDaoSelect extends ActionVisitorTemplateStmtV2<OrderveInfo> {

	public VisiOrderveDaoSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrderveInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderveInfo>> stmtOptions) {
		return new DaoOrderveSelect(stmtOptions);
	}
}
