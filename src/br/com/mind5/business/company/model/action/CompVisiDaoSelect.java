package br.com.mind5.business.company.model.action;

import java.util.List;

import br.com.mind5.business.company.dao.CompDaoSelect;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompVisiDaoSelect extends ActionVisitorTemplateStmt<CompInfo> {

	public CompVisiDaoSelect(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CompInfo> buildStmtExecHook(List<DaoStmtExecOption<CompInfo>> stmtOptions) {
		return new CompDaoSelect(stmtOptions);
	}
}
