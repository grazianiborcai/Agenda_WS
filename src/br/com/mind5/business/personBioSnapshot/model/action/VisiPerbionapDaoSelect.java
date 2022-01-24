package br.com.mind5.business.personBioSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personBioSnapshot.dao.DaoPerbionapSelect;
import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbionapDaoSelect extends ActionVisitorTemplateStmt<PerbionapInfo> {

	public VisiPerbionapDaoSelect(DeciTreeOption<PerbionapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PerbionapInfo> buildStmtExecHook(List<DaoStmtExecOption<PerbionapInfo>> stmtOptions) {
		return new DaoPerbionapSelect(stmtOptions);
	}
}
