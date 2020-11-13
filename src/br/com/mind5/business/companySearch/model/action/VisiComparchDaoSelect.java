package br.com.mind5.business.companySearch.model.action;

import java.util.List;

import br.com.mind5.business.companySearch.dao.DaoComparchSelect;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiComparchDaoSelect extends ActionVisitorTemplateStmt<ComparchInfo> {

	public VisiComparchDaoSelect(DeciTreeOption<ComparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<ComparchInfo> buildStmtExecHook(List<DaoStmtExecOption<ComparchInfo>> stmtOptions) {
		return new DaoComparchSelect(stmtOptions);
	}
}
