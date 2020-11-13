package br.com.mind5.business.materialTextSearch.model.action;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextarchDaoSelect extends ActionStdTemplate<MatextarchInfo> {

	public StdMatextarchDaoSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatextarchInfo> buildVisitorHook(DeciTreeOption<MatextarchInfo> option) {
		return new VisiMatextarchDaoSelect(option);
	}
}
