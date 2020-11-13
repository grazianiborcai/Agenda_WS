package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.dao.DaoCartDelete;
import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartDaoDelete extends ActionVisitorTemplateStmt<CartInfo> {

	public VisiCartDaoDelete(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CartInfo> buildStmtExecHook(List<DaoStmtExecOption<CartInfo>> stmtOptions) {
		return new DaoCartDelete(stmtOptions);
	}
}
