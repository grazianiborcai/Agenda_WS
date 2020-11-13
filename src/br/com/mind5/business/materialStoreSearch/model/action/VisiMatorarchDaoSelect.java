package br.com.mind5.business.materialStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSearch.dao.DaoMatorarchSelect;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatorarchDaoSelect extends ActionVisitorTemplateStmt<MatorarchInfo> {

	public VisiMatorarchDaoSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatorarchInfo> buildStmtExecHook(List<DaoStmtExecOption<MatorarchInfo>> stmtOptions) {
		return new DaoMatorarchSelect(stmtOptions);
	}
}
