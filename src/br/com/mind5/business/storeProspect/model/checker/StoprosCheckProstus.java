package br.com.mind5.business.storeProspect.model.checker;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.masterData.prospectStatus.model.checker.ProstusCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class StoprosCheckProstus extends ModelCheckerTemplateForwardV2<StoprosInfo, ProstusInfo> {
	
	public StoprosCheckProstus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<ProstusInfo> getCheckerHook(ModelCheckerOption option) {
		return new ProstusCheckExist(option);
	}
	
	
	
	@Override protected ProstusInfo toForwardClass(StoprosInfo baseRecord) {
		return ProstusInfo.copyFrom(baseRecord);
	}
}
