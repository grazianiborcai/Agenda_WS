package br.com.mind5.business.phoneDefault.model.action;

import java.util.List;

import br.com.mind5.business.phoneDefault.dao.PhonaultDaoSelect;
import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class PhonaultVisiDaoSelect extends ActionVisitorTemplateStmt<PhonaultInfo> {

	public PhonaultVisiDaoSelect(DeciTreeOption<PhonaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PhonaultInfo> buildStmtExecHook(List<DaoStmtExecOption<PhonaultInfo>> stmtOptions) {
		return new PhonaultDaoSelect(stmtOptions);
	}
}
