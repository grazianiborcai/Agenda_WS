package br.com.mind5.geo.geoCode.model.checker;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class GeodeCheckLangu extends ModelCheckerTemplateForwardV2<GeodeInfo, LanguInfo> {
	
	public GeodeCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(GeodeInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
