package br.com.mind5.payment.countryPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.dao.DaoCounparSelect;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

final class VisiCounparDaoSelect extends ActionVisitorTemplateStmt<CounparInfo> {

	public VisiCounparDaoSelect(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CounparInfo> buildStmtExecHook(List<DaoStmtExecOption<CounparInfo>> stmtOptions) {
		return new DaoCounparSelect(stmtOptions);
	}
}
