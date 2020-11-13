package br.com.mind5.payment.countryPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.dao.DaoCounparchSelect;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

final class VisiCounparchDaoSelect extends ActionVisitorTemplateStmt<CounparchInfo> {

	public VisiCounparchDaoSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<CounparchInfo> buildStmtExecHook(List<DaoStmtExecOption<CounparchInfo>> stmtOptions) {
		return new DaoCounparchSelect(stmtOptions);
	}
}
