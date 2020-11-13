package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.dao.DaoCartemDelete;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemDaoDelete extends ActionVisitorTemplateStmt<CartemInfo> {

	public VisiCartemDaoDelete(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CartemInfo> buildStmtExecHook(List<DaoStmtExecOption<CartemInfo>> stmtOptions) {
		return new DaoCartemDelete(stmtOptions);
	}
}
