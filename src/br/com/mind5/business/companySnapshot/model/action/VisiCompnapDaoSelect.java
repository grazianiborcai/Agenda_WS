package br.com.mind5.business.companySnapshot.model.action;

import java.util.List;

import br.com.mind5.business.companySnapshot.dao.DaoCompnapSelect;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCompnapDaoSelect extends ActionVisitorTemplateStmtV2<CompnapInfo> {

	public VisiCompnapDaoSelect(DeciTreeOption<CompnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CompnapInfo> buildStmtExecHook(List<DaoStmtExecOption<CompnapInfo>> stmtOptions) {
		return new DaoCompnapSelect(stmtOptions);
	}
}
