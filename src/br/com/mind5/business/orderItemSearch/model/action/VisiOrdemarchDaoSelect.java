package br.com.mind5.business.orderItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSearch.dao.DaoOrdemarchSelect;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemarchDaoSelect extends ActionVisitorTemplateStmt<OrdemarchInfo> {

	public VisiOrdemarchDaoSelect(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<OrdemarchInfo> buildStmtExecHook(List<DaoStmtExecOption<OrdemarchInfo>> stmtOptions) {
		return new DaoOrdemarchSelect(stmtOptions);
	}
}
