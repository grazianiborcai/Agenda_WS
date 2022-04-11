package br.com.mind5.business.orderSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderSearch.dao.OrdarchDaoSelect;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdarchVisiDaoSelect extends ActionVisitorTemplateStmt<OrdarchInfo> {

	public OrdarchVisiDaoSelect(DeciTreeOption<OrdarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdarchInfo>> stmtOptions) {
		return new OrdarchDaoSelect(stmtOptions);
	}
}
