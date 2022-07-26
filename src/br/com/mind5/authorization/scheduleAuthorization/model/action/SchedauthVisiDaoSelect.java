package br.com.mind5.authorization.scheduleAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.dao.SchedauthDaoSelect;
import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedauthVisiDaoSelect extends ActionVisitorTemplateStmt<SchedauthInfo> {

	public SchedauthVisiDaoSelect(DeciTreeOption<SchedauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<SchedauthInfo> buildStmtExecHook(List<DaoStmtExecOption<SchedauthInfo>> stmtOptions) {
		return new SchedauthDaoSelect(stmtOptions);
	}
}
