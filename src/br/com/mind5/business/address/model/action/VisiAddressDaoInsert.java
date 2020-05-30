package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.dao.DaoAddressInsert;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressDaoInsert extends ActionVisitorTemplateStmtV2<AddressInfo> {

	public VisiAddressDaoInsert(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AddressInfo> buildStmtExecHook(List<DaoStmtExecOption<AddressInfo>> stmtOptions) {
		return new DaoAddressInsert(stmtOptions);
	}
}
