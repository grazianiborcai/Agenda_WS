package br.com.mind5.geo.geoCode.model.action;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.info.GeodeSetterLocation;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GeodeVisiEnforceLocation extends ActionVisitorTemplateEnforce<GeodeInfo> {
	
	public GeodeVisiEnforceLocation(DeciTreeOption<GeodeInfo> option) {
		super(option);
	}

	
	
	@Override protected GeodeInfo enforceHook(GeodeInfo recordInfo) {
		InfoSetter<GeodeInfo> attrSetter = new GeodeSetterLocation();
		return attrSetter.setAttr(recordInfo);
	}
}
