package br.com.mind5.business.personBioSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personBioSnapshot.dao.PerbionapDaoSelect;
import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbionapVisiDaoSelect extends ActionVisitorTemplateStmt<PerbionapInfo> {

	public PerbionapVisiDaoSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PerbionapInfo> buildStmtExecHook(List<DaoStmtExecOption<PerbionapInfo>> stmtOptions) {
		return new PerbionapDaoSelect(stmtOptions);
	}
}
