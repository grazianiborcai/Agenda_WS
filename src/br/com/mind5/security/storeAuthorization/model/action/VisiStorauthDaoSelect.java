package br.com.mind5.security.storeAuthorization.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.dao.DaoStorauthSelect;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

final class VisiStorauthDaoSelect extends ActionVisitorTemplateStmtV2<StorauthInfo>{

	public VisiStorauthDaoSelect(DeciTreeOption<StorauthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StorauthInfo> buildStmtExecHook(List<DaoStmtExecOption<StorauthInfo>> stmtOptions) {
		return new DaoStorauthSelect(stmtOptions);
	}
}
