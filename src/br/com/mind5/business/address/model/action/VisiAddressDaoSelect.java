package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.dao.DaoAddressSelect;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmt;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressDaoSelect extends ActionVisitorTemplateStmt<AddressInfo> {

	public VisiAddressDaoSelect(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AddressInfo> buildStmtExecHook(List<DaoStmtExecOption<AddressInfo>> stmtOptions) {
		return new DaoAddressSelect(stmtOptions);
	}
}
