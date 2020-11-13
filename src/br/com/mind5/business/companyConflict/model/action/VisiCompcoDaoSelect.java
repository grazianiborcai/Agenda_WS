package br.com.mind5.business.companyConflict.model.action;

import java.util.List;

import br.com.mind5.business.companyConflict.dao.DaoCompcoSelect;
import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompcoDaoSelect extends ActionVisitorTemplateStmt<CompcoInfo> {

	public VisiCompcoDaoSelect(DeciTreeOption<CompcoInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CompcoInfo> buildStmtExecHook(List<DaoStmtExecOption<CompcoInfo>> stmtOptions) {
		return new DaoCompcoSelect(stmtOptions);
	}
}
