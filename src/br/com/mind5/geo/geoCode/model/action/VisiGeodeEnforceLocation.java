package br.com.mind5.geo.geoCode.model.action;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.info.GeodeSetterLocation;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGeodeEnforceLocation extends ActionVisitorTemplateEnforceV2<GeodeInfo> {
	
	public VisiGeodeEnforceLocation(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}

	
	
	@Override protected GeodeInfo enforceHook(GeodeInfo recordInfo) {
		InfoSetter<GeodeInfo> attrSetter = new GeodeSetterLocation();
		return attrSetter.setAttr(recordInfo);
	}
}
