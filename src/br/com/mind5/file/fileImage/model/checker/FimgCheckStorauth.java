package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckAuthorization;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class FimgCheckStorauth extends ModelCheckerTemplateForwardV2<FimgInfo, StorauthInfo> {
	
	public FimgCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckAuthorization(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(FimgInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
