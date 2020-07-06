package br.com.mind5.business.customerSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.dao.DaoCusarchSelect;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusarchDaoSelect extends ActionVisitorTemplateStmtV2<CusarchInfo> {

	public VisiCusarchDaoSelect(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CusarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CusarchInfo>> stmtOptions) {
		return new DaoCusarchSelect(stmtOptions);
	}
}
