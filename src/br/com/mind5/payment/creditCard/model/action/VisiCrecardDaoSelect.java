package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.dao.DaoCrecardSelect;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class VisiCrecardDaoSelect extends ActionVisitorTemplateStmtV2<CrecardInfo>{

	public VisiCrecardDaoSelect(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CrecardInfo> buildStmtExecHook(List<DaoStmtExecOption<CrecardInfo>> stmtOptions) {
		return new DaoCrecardSelect(stmtOptions);
	}
}