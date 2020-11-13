package br.com.mind5.business.cartReserve.model.action;

import java.util.List;

import br.com.mind5.business.cartReserve.dao.DaoCarterveSelect;
import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCarterveDaoSelect extends ActionVisitorTemplateStmt<CarterveInfo> {

	public VisiCarterveDaoSelect(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CarterveInfo> buildStmtExecHook(List<DaoStmtExecOption<CarterveInfo>> stmtOptions) {
		return new DaoCarterveSelect(stmtOptions);
	}
}
