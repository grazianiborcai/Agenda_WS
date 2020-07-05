package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.dao.DaoCusUpdate;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusDaoUpdate extends ActionVisitorTemplateStmtV2<CusInfo> {

	public VisiCusDaoUpdate(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CusInfo> buildStmtExecHook(List<DaoStmtExecOption<CusInfo>> stmtOptions) {
		return new DaoCusUpdate(stmtOptions);
	}
}
