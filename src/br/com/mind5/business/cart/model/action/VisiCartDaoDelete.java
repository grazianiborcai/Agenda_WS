package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.dao.DaoCartDelete;
import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartDaoDelete extends ActionVisitorTemplateStmtV2<CartInfo>{

	public VisiCartDaoDelete(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CartInfo> buildStmtExecHook(List<DaoStmtExecOption<CartInfo>> stmtOptions) {
		return new DaoCartDelete(stmtOptions);
	}
}
