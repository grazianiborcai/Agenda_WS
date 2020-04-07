package br.com.mind5.business.owner.model.action;

import java.util.List;

import br.com.mind5.business.owner.dao.DaoOwnerDelete;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOwnerDaoDelete extends ActionVisitorTemplateStmtV2<OwnerInfo>{

	public VisiOwnerDaoDelete(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<OwnerInfo> buildStmtExecHook(List<DaoStmtExecOption<OwnerInfo>> stmtOptions) {
		return new DaoOwnerDelete(stmtOptions);
	}
}
