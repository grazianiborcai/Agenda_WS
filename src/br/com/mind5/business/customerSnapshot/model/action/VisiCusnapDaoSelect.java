package br.com.mind5.business.customerSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerSnapshot.dao.DaoCusnapSelect;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusnapDaoSelect extends ActionVisitorTemplateStmt<CusnapInfo> {

	public VisiCusnapDaoSelect(DeciTreeOption<CusnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusnapInfo> buildStmtExecHook(List<DaoStmtExecOption<CusnapInfo>> stmtOptions) {
		return new DaoCusnapSelect(stmtOptions);
	}
}
