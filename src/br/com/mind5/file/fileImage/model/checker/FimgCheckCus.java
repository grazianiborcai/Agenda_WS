package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class FimgCheckCus extends ModelCheckerTemplateForwardV2<FimgInfo, CusInfo> {
	
	public FimgCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(FimgInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
