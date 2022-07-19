package br.com.mind5.payment.countryPartnerSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.dao.CounparchDaoSelect;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparchVisiDaoSelect extends ActionVisitorTemplateStmt<CounparchInfo> {

	public CounparchVisiDaoSelect(DeciTreeOption<CounparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CounparchInfo> buildStmtExecHook(List<DaoStmtExecOption<CounparchInfo>> stmtOptions) {
		return new CounparchDaoSelect(stmtOptions);
	}
}
