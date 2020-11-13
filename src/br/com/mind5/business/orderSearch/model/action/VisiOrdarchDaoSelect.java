package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.dao.DaoOrdarchSelect;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdarchDaoSelect extends ActionVisitorTemplateStmt<OrdarchInfo> {

	public VisiOrdarchDaoSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OrdarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdarchInfo>> stmtOptions) {
		return new DaoOrdarchSelect(stmtOptions);
	}
}
