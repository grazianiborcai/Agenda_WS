package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.dao.DaoPerbioUpdate;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerbioDaoUpdate extends ActionVisitorTemplateStmt<PerbioInfo> {

	public VisiPerbioDaoUpdate(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PerbioInfo> buildStmtExecHook(List<DaoStmtExecOption<PerbioInfo>> stmtOptions) {
		return new DaoPerbioUpdate(stmtOptions);
	}
}
