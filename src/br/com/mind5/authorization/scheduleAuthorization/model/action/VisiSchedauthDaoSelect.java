package br.com.mind5.authorization.scheduleAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.dao.DaoSchedauthSelect;
import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedauthDaoSelect extends ActionVisitorTemplateStmtV2<SchedauthInfo> {

	public VisiSchedauthDaoSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<SchedauthInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedauthInfo>> stmtOptions) {
		return new DaoSchedauthSelect(stmtOptions);
	}
}
