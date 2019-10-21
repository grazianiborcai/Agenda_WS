package br.com.mind5.file.fileImageSearch.model.checker;

import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class FimarchCheckOwner implements ModelChecker<FimarchInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OwnerInfo> checker;
	
	
	public FimarchCheckOwner(ModelCheckerOption option) {
		checker = new OwnerCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FimarchInfo> recordInfos) {
		for (FimarchInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FimarchInfo recordInfo) {
		return checker.check(OwnerInfo.copyFrom(recordInfo));
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
