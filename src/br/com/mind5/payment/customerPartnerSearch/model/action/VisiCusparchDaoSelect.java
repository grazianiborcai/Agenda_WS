package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.dao.DaoCusparchSelect;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

final class VisiCusparchDaoSelect extends ActionVisitorTemplateStmtV2<CusparchInfo> {

	public VisiCusparchDaoSelect(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CusparchInfo> buildStmtExecHook(List<DaoStmtExecOption<CusparchInfo>> stmtOptions) {
		return new DaoCusparchSelect(stmtOptions);
	}
}
