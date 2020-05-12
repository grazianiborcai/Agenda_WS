package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.dao.DaoCusparSelect;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class VisiCusparDaoSelect extends ActionVisitorTemplateStmtV2<CusparInfo> {

	public VisiCusparDaoSelect(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CusparInfo> buildStmtExecHook(List<DaoStmtExecOption<CusparInfo>> stmtOptions) {
		return new DaoCusparSelect(stmtOptions);
	}
}
