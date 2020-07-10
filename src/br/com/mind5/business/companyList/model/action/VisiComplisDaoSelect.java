package br.com.mind5.business.companyList.model.action;

import java.util.List;

import br.com.mind5.business.companyList.dao.DaoComplisSelect;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiComplisDaoSelect extends ActionVisitorTemplateStmtV2<ComplisInfo> {

	public VisiComplisDaoSelect(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<ComplisInfo> buildStmtExecHook(List<DaoStmtExecOption<ComplisInfo>> stmtOptions) {
		return new DaoComplisSelect(stmtOptions);
	}
}
