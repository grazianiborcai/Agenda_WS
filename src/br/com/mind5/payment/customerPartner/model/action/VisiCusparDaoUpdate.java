package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.dao.DaoCusparUpdate;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class VisiCusparDaoUpdate extends ActionVisitorTemplateStmt<CusparInfo> {

	public VisiCusparDaoUpdate(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CusparInfo> buildStmtExecHook(List<DaoStmtExecOption<CusparInfo>> stmtOptions) {
		return new DaoCusparUpdate(stmtOptions);
	}
}
