package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.dao.DaoCrecarchSelect;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

final class VisiCrecarchDaoSelect extends ActionVisitorTemplateStmtV2<CrecarchInfo> {

	public VisiCrecarchDaoSelect(DeciTreeOption<CrecarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CrecarchInfo> buildStmtExecHook(List<DaoStmtExecOption<CrecarchInfo>> stmtOptions) {
		return new DaoCrecarchSelect(stmtOptions);
	}
}
