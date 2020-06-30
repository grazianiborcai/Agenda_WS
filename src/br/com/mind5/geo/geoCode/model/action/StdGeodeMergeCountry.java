package br.com.mind5.geo.geoCode.model.action;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGeodeMergeCountry extends ActionStdTemplateV2<GeodeInfo> {

	public StdGeodeMergeCountry(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<GeodeInfo> buildVisitorHook(DeciTreeOption<GeodeInfo> option) {
		return new VisiGeodeMergeCountry(option);
	}
}
