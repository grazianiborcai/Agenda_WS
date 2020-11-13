package br.com.mind5.masterData.cartItemCategory.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.cartItemCategory.dao.DaoCaritegSelect;
import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCaritegDaoSelect extends ActionVisitorTemplateStmt<CaritegInfo> {

	public VisiCaritegDaoSelect(DeciTreeOption<CaritegInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CaritegInfo> buildStmtExecHook(List<DaoStmtExecOption<CaritegInfo>> stmtOptions) {
		return new DaoCaritegSelect(stmtOptions);
	}
}
