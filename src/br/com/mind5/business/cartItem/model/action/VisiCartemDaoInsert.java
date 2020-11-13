package br.com.mind5.business.cartItem.model.action;

import java.util.List;

import br.com.mind5.business.cartItem.dao.DaoCartemInsert;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemDaoInsert extends ActionVisitorTemplateStmt<CartemInfo> {

	public VisiCartemDaoInsert(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CartemInfo> buildStmtExecHook(List<DaoStmtExecOption<CartemInfo>> stmtOptions) {
		return new DaoCartemInsert(stmtOptions);
	}
}
