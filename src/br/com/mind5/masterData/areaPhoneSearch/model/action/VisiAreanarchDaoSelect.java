package br.com.mind5.masterData.areaPhoneSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.areaPhoneSearch.dao.DaoAreanarchSelect;
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAreanarchDaoSelect extends ActionVisitorTemplateStmtV2<AreanarchInfo>{

	public VisiAreanarchDaoSelect(DeciTreeOption<AreanarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<AreanarchInfo> buildStmtExecHook(List<DaoStmtExecOption<AreanarchInfo>> stmtOptions) {
		return new DaoAreanarchSelect(stmtOptions);
	}
}
