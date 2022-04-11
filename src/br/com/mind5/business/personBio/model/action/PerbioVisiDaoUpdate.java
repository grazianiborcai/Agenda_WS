package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.dao.PerbioDaoUpdate;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioVisiDaoUpdate extends ActionVisitorTemplateStmt<PerbioInfo> {

	public PerbioVisiDaoUpdate(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<PerbioInfo> buildStmtExecHook(List<DaoStmtExecOption<PerbioInfo>> stmtOptions) {
		return new PerbioDaoUpdate(stmtOptions);
	}
}
