package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.PeresmoipDaoSelect;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipVisiDaoSelect extends ActionVisitorTemplateStmt<PeresmoipInfo> {

	public PeresmoipVisiDaoSelect(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PeresmoipInfo> buildStmtExecHook(List<DaoStmtExecOption<PeresmoipInfo>> stmtOptions) {
		return new PeresmoipDaoSelect(stmtOptions);
	}
}
