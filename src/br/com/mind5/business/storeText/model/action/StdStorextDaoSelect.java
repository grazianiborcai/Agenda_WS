package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextDaoSelect extends ActionStdTemplate<StorextInfo> {

	public StdStorextDaoSelect(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorextInfo> buildVisitorHook(DeciTreeOption<StorextInfo> option) {
		return new VisiStorextDaoSelect(option);
	}
}
