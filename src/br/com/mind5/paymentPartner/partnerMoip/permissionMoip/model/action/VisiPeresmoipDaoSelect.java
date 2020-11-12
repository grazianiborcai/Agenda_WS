package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.DaoPeresmoipSelect;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

final class VisiPeresmoipDaoSelect extends ActionVisitorTemplateStmtV2<PeresmoipInfo> {

	public VisiPeresmoipDaoSelect(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PeresmoipInfo> buildStmtExecHook(List<DaoStmtExecOption<PeresmoipInfo>> stmtOptions) {
		return new DaoPeresmoipSelect(stmtOptions);
	}
}