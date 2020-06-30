package br.com.mind5.geo.geoCode.model.checker;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class GeodeCheckCountry extends ModelCheckerTemplateForwardV2<GeodeInfo, CountryInfo> {
	
	public GeodeCheckCountry(ModelCheckerOption option) {
		super(option);
	}

	

	@Override protected ModelCheckerV1<CountryInfo> getCheckerHook(ModelCheckerOption option) {
		return new CountryCheckExist(option);
	}
	
	
	
	@Override protected CountryInfo toForwardClass(GeodeInfo baseRecord) {
		return CountryInfo.copyFrom(baseRecord);
	}
}
