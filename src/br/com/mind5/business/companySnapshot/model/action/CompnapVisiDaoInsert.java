package br.com.mind5.business.companySnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companySnapshot.dao.CompnapDaoInsert;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CompnapVisiDaoInsert extends ActionVisitorTemplateStmt<CompnapInfo> {

	public CompnapVisiDaoInsert(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CompnapInfo> buildStmtExecHook(List<DaoStmtExecOption<CompnapInfo>> stmtOptions) {
		return new CompnapDaoInsert(stmtOptions);
	}
}
