package br.com.mind5.authorization.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.dao.DaoStorauthSelect;
import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorauthDaoSelect extends ActionVisitorTemplateStmt<StorauthInfo> {

	public VisiStorauthDaoSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExec<StorauthInfo> buildStmtExecHook(List<DaoStmtExecOption<StorauthInfo>> stmtOptions) {
		return new DaoStorauthSelect(stmtOptions);
	}
}
