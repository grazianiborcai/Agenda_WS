package br.com.mind5.masterData.areaPhone.model.action;

import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAreaneDaoSelect extends ActionStdTemplate<AreaneInfo> {

	public StdAreaneDaoSelect(DeciTreeOption<AreaneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AreaneInfo> buildVisitorHook(DeciTreeOption<AreaneInfo> option) {
		return new VisiAreaneDaoSelect(option);
	}
}
