package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchCopier;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.checker.FimarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class FimgCheckFimarchUser extends ModelCheckerTemplateForward<FimgInfo, FimarchInfo> {
	
	public FimgCheckFimarchUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<FimarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new FimarchCheckExist(option);
	}
	
	
	
	@Override protected FimarchInfo toForwardClass(FimgInfo baseRecord) {
		return FimarchCopier.copyFromFimgUser(baseRecord);
	}
}
