package br.com.mind5.business.scheduleLine.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedineCheckCus extends ModelCheckerTemplateForwardV2<SchedineInfo, CusInfo> {
	
	public SchedineCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(SchedineInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
