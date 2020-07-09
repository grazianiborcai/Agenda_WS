package br.com.mind5.business.materialMovement.model.checker;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthorization;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatmovCheckStorauth implements ModelCheckerV1<MatmovInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<StorauthInfo> checker;
	
	
	public MatmovCheckStorauth(ModelCheckerOption option) {
		checker = new StorauthCheckAuthorization(option);
	}
	
	
	
	@Override public boolean check(List<MatmovInfo> recordInfos) {
		for (MatmovInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatmovInfo recordInfo) {
		return checker.check(StorauthInfo.copyFrom(recordInfo));
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
