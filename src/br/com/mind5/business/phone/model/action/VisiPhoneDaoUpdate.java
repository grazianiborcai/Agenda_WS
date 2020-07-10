package br.com.mind5.business.phone.model.action;

import java.util.List;

import br.com.mind5.business.phone.dao.DaoPhoneUpdate;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPhoneDaoUpdate extends ActionVisitorTemplateStmtV2<PhoneInfo> {

	public VisiPhoneDaoUpdate(DeciTreeOption<PhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<PhoneInfo> buildStmtExecHook(List<DaoStmtExecOption<PhoneInfo>> stmtOptions) {
		return new DaoPhoneUpdate(stmtOptions);
	}
}
