package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.dao.DaoMatorapSelect;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatorapDaoSelect extends ActionVisitorTemplateStmtV2<MatorapInfo> {

	public VisiMatorapDaoSelect(DeciTreeOption<MatorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<MatorapInfo> buildStmtExecHook(List<DaoStmtExecOption<MatorapInfo>> stmtOptions) {
		return new DaoMatorapSelect(stmtOptions);
	}
}
