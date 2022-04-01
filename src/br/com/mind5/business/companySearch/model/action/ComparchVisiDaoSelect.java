package br.com.mind5.business.companySearch.model.action;

import java.util.List;

import br.com.mind5.business.companySearch.dao.ComparchDaoSelect;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ComparchVisiDaoSelect extends ActionVisitorTemplateStmt<ComparchInfo> {

	public ComparchVisiDaoSelect(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<ComparchInfo> buildStmtExecHook(List<DaoStmtExecOption<ComparchInfo>> stmtOptions) {
		return new ComparchDaoSelect(stmtOptions);
	}
}
