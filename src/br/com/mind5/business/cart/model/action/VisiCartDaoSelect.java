package br.com.mind5.business.cart.model.action;

import java.util.List;

import br.com.mind5.business.cart.dao.DaoCartSelect;
import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartDaoSelect extends ActionVisitorTemplateStmtV2<CartInfo>{

	public VisiCartDaoSelect(DeciTreeOption<CartInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CartInfo> buildStmtExecHook(List<DaoStmtExecOption<CartInfo>> stmtOptions) {
		return new DaoCartSelect(stmtOptions);
	}
}
