package br.com.mind5.geo.geoCode.model.action;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGeodeEnforceLocation extends ActionStdTemplateV2<GeodeInfo> {

	public StdGeodeEnforceLocation(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<GeodeInfo> buildVisitorHook(DeciTreeOption<GeodeInfo> option) {
		return new VisiGeodeEnforceLocation(option);
	}
}
