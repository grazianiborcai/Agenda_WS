package br.com.mind5.geo.geoCode.model.action;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGeodeEnforceLocation extends ActionStdTemplate<GeodeInfo> {

	public StdGeodeEnforceLocation(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<GeodeInfo> buildVisitorHook(DeciTreeOption<GeodeInfo> option) {
		return new VisiGeodeEnforceLocation(option);
	}
}
