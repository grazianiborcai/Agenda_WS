package br.com.gda.business.company.model.checker;

import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.masterData.info.EntityCategInfo;
import br.com.gda.business.masterData.model.checker.EntityCategCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CompCheckEntityCateg implements ModelChecker<CompInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EntityCategInfo> checker;
	
	
	public CompCheckEntityCateg(ModelCheckerOption option) {
		checker = new EntityCategCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CompInfo> recordInfos) {
		for (CompInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CompInfo recordInfo) {
		return checker.check(EntityCategInfo.copyFrom(recordInfo));
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
