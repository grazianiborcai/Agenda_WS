package br.com.mind5.masterData.orderStatusSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.orderStatusSearch.dao.OrderatarchDaoSelect;
import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderatarchVisiDaoSelect extends ActionVisitorTemplateStmt<OrderatarchInfo> {

	public OrderatarchVisiDaoSelect(DeciTreeOption<OrderatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrderatarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OrderatarchInfo>> stmtOptions) {
		return new OrderatarchDaoSelect(stmtOptions);
	}
}
