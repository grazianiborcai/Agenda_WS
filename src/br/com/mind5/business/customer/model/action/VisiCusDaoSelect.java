package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.dao.DaoCusSelect;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusDaoSelect extends ActionVisitorTemplateStmt<CusInfo> {

	public VisiCusDaoSelect(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusInfo> buildStmtExecHook(List<DaoStmtExecOption<CusInfo>> stmtOptions) {
		return new DaoCusSelect(stmtOptions);
	}
}
