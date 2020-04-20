package br.com.mind5.masterData.areaPhone.model.action;

import br.com.mind5.masterData.areaPhone.info.AreaneInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAreaneDaoSelect extends ActionStdTemplateV2<AreaneInfo> {

	public StdAreaneDaoSelect(DeciTreeOption<AreaneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AreaneInfo> buildVisitorHook(DeciTreeOption<AreaneInfo> option) {
		return new VisiAreaneDaoSelect(option);
	}
}
