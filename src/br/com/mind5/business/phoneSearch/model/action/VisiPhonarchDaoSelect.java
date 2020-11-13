package br.com.mind5.business.phoneSearch.model.action;

import java.util.List;

import br.com.mind5.business.phoneSearch.dao.DaoPhonarchSelect;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhonarchDaoSelect extends ActionVisitorTemplateStmt<PhonarchInfo> {

	public VisiPhonarchDaoSelect(DeciTreeOption<PhonarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PhonarchInfo> buildStmtExecHook(List<DaoStmtExecOption<PhonarchInfo>> stmtOptions) {
		return new DaoPhonarchSelect(stmtOptions);
	}
}
