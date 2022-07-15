package br.com.mind5.payment.countryPartner.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.dao.CounparDaoSelect;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class CounparVisiDaoSelect extends ActionVisitorTemplateStmt<CounparInfo> {

	public CounparVisiDaoSelect(DeciTreeOption<CounparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<CounparInfo> buildStmtExecHook(List<DaoStmtExecOption<CounparInfo>> stmtOptions) {
		return new CounparDaoSelect(stmtOptions);
	}
}
