package br.com.mind5.business.address.model.checker;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.model.checker.GeodeCheckCoding;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class AddressCheckHasGeode extends ModelCheckerTemplateForwardV2<AddressInfo, GeodeInfo> {
	
	public AddressCheckHasGeode(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<GeodeInfo> getCheckerHook(ModelCheckerOption option) {
		return new GeodeCheckCoding(option);
	}
	
	
	
	@Override protected GeodeInfo toForwardClass(AddressInfo baseRecord) {
		return GeodeInfo.copyFrom(baseRecord);
	}
}
