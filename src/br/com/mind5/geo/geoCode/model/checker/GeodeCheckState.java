package br.com.mind5.geo.geoCode.model.checker;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.checker.StateCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class GeodeCheckState extends ModelCheckerTemplateForwardV2<GeodeInfo, StateInfo> {
	
	public GeodeCheckState(ModelCheckerOption option) {
		super(option);
	}

	

	@Override protected ModelCheckerV1<StateInfo> getCheckerHook(ModelCheckerOption option) {
		return new StateCheckExist(option);
	}
	
	
	
	@Override protected StateInfo toForwardClass(GeodeInfo baseRecord) {
		return StateInfo.copyFrom(baseRecord);
	}
}
