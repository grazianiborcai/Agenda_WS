package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.checker.CusarchCheckExistUser;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class FimgCheckCusarch extends ModelCheckerTemplateForward<FimgInfo, CusarchInfo> {
	
	public FimgCheckCusarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusarchCheckExistUser(option);
	}
	
	
	
	@Override protected CusarchInfo toForwardClass(FimgInfo baseRecord) {
		return CusarchInfo.copyFrom(baseRecord);
	}
}
