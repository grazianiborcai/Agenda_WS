package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.dao.DaoCartemSelect;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemDaoSelect extends ActionVisitorTemplateStmt<CartemInfo> {

	public VisiCartemDaoSelect(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CartemInfo> buildStmtExecHook(List<DaoStmtExecOption<CartemInfo>> stmtOptions) {
		return new DaoCartemSelect(stmtOptions);
	}
}
