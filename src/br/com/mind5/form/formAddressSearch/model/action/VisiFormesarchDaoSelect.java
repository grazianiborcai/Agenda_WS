package br.com.mind5.form.formAddressSearch.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.form.formAddressSearch.dao.DaoFormesarchSelect;
import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormesarchDaoSelect extends ActionVisitorTemplateStmtV2<FormesarchInfo>{

	public VisiFormesarchDaoSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FormesarchInfo> buildStmtExecHook(List<DaoStmtExecOption<FormesarchInfo>> stmtOptions) {
		return new DaoFormesarchSelect(stmtOptions);
	}
}