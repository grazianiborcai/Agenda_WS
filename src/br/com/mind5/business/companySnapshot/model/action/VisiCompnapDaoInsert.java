package br.com.mind5.business.companySnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companySnapshot.dao.DaoCompnapInsert;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompnapDaoInsert extends ActionVisitorTemplateStmt<CompnapInfo> {

	public VisiCompnapDaoInsert(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CompnapInfo> buildStmtExecHook(List<DaoStmtExecOption<CompnapInfo>> stmtOptions) {
		return new DaoCompnapInsert(stmtOptions);
	}
}
