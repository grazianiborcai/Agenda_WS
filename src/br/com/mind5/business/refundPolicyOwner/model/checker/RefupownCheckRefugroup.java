package br.com.mind5.business.refundPolicyOwner.model.checker;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.checker.RefugroupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class RefupownCheckRefugroup implements ModelCheckerV1<RefupownInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelCheckerV1<RefugroupInfo> checker;
	
	
	public RefupownCheckRefugroup(ModelCheckerOption option) {
		checker = new RefugroupCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<RefupownInfo> recordInfos) {
		for (RefupownInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(RefupownInfo recordInfo) {
		return checker.check(RefugroupInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
