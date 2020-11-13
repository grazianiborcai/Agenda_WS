package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.dao.DaoCartSelect;
import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartDaoSelect extends ActionVisitorTemplateStmt<CartInfo> {

	public VisiCartDaoSelect(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CartInfo> buildStmtExecHook(List<DaoStmtExecOption<CartInfo>> stmtOptions) {
		return new DaoCartSelect(stmtOptions);
	}
}
