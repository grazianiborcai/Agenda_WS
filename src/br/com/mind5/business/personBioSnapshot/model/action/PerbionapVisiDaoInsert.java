package br.com.mind5.business.personBioSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personBioSnapshot.dao.PerbionapDaoInsert;
import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbionapVisiDaoInsert extends ActionVisitorTemplateStmt<PerbionapInfo> {

	public PerbionapVisiDaoInsert(DeciTreeOption<PerbionapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PerbionapInfo> buildStmtExecHook(List<DaoStmtExecOption<PerbionapInfo>> stmtOptions) {
		return new PerbionapDaoInsert(stmtOptions);
	}
}
