package br.com.mind5.business.employee.model.checker;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpCheckSytotin extends ModelCheckerTemplateForwardV2<EmpInfo, SytotinInfo> {
	
	public EmpCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(EmpInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
