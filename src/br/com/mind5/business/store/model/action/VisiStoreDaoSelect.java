package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.dao.DaoStoreSelect;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDaoSelect extends ActionVisitorTemplateStmtV2<StoreInfo>{

	public VisiStoreDaoSelect(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<StoreInfo> buildStmtExecHook(List<DaoStmtExecOption<StoreInfo>> stmtOptions) {
		return new DaoStoreSelect(stmtOptions);
	}
}