package br.com.mind5.business.orderItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSearch.dao.OrdemarchDaoSelect;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemarchVisiDaoSelect extends ActionVisitorTemplateStmt<OrdemarchInfo> {

	public OrdemarchVisiDaoSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdemarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemarchInfo>> stmtOptions) {
		return new OrdemarchDaoSelect(stmtOptions);
	}
}
