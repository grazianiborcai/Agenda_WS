package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.dao.DaoCusparUpdate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class VisiCusparDaoUpdate extends ActionVisitorTemplateStmtV2<CusparInfo> {

	public VisiCusparDaoUpdate(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CusparInfo> buildStmtExecHook(List<DaoStmtExecOption<CusparInfo>> stmtOptions) {
		return new DaoCusparUpdate(stmtOptions);
	}
}
