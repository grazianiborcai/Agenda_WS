package br.com.mind5.form.formAddress.model.action;

import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.form.formAddress.dao.DaoFormessSelect;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.model.action.ActionVisitorTemplateStmtV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiFormessDaoSelect extends ActionVisitorTemplateStmtV2<FormessInfo>{

	public VisiFormessDaoSelect(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected DaoStmtExecV2<FormessInfo> buildStmtExecHook(List<DaoStmtExecOption<FormessInfo>> stmtOptions) {
		return new DaoFormessSelect(stmtOptions);
	}
}
