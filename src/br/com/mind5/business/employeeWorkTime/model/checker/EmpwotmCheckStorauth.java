package br.com.mind5.business.employeeWorkTime.model.checker;

import java.util.List;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthorization;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmpwotmCheckStorauth implements ModelCheckerV1<EmpwotmInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<StorauthInfo> checker;
	
	
	public EmpwotmCheckStorauth(ModelCheckerOption option) {
		checker = new StorauthCheckAuthorization(option);
	}
	
	
	
	@Override public boolean check(List<EmpwotmInfo> recordInfos) {
		for (EmpwotmInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpwotmInfo recordInfo) {
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
