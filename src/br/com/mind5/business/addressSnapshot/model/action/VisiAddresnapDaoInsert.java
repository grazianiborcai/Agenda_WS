package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.dao.DaoAddresnapInsert;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddresnapDaoInsert extends ActionVisitorTemplateStmtV2<AddresnapInfo> {

	public VisiAddresnapDaoInsert(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AddresnapInfo> buildStmtExecHook(List<DaoStmtExecOption<AddresnapInfo>> stmtOptions) {
		return new DaoAddresnapInsert(stmtOptions);
	}
}
