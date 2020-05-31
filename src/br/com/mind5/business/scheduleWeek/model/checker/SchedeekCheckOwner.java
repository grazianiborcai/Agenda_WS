package br.com.mind5.business.scheduleWeek.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedeekCheckOwner extends ModelCheckerTemplateForwardV2<SchedeekInfo, OwnerInfo> {
	
	public SchedeekCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(SchedeekInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
