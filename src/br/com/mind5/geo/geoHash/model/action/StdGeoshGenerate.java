package br.com.mind5.geo.geoHash.model.action;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGeoshGenerate extends ActionStdTemplateV2<GeoshInfo> {

	public StdGeoshGenerate(DeciTreeOption<GeoshInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<GeoshInfo> buildVisitorHook(DeciTreeOption<GeoshInfo> option) {
		return new VisiGeoshGenerate(option);
	}
}
