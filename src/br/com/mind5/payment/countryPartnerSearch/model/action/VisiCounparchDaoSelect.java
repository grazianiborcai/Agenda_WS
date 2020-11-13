package br.com.mind5.payment.countryPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.dao.DaoCounparchSelect;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

final class VisiCounparchDaoSelect extends ActionVisitorTemplateStmtV2<CounparchInfo> {

	public VisiCounparchDaoSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CounparchInfo> buildStmtExecHook(List<DaoStmtExecOption<CounparchInfo>> stmtOptions) {
		return new DaoCounparchSelect(stmtOptions);
	}
}
