package br.com.mind5.masterData.orderStatus.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.orderStatus.dao.OrderatusDaoSelect;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderatusVisiDaoSelect extends ActionVisitorTemplateStmt<OrderatusInfo> {

	public OrderatusVisiDaoSelect(DeciTreeOption<OrderatusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrderatusInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderatusInfo>> stmtOptions) {
		return new OrderatusDaoSelect(stmtOptions);
	}
}
