package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelectOwner;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgCheckExistOwner extends ModelCheckerTemplateActionV2<FimgInfo, FimarchInfo> {	
	
	public FimgCheckExistOwner(ModelCheckerOption option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<FimarchInfo> buildActionHook(DeciTreeOption<FimarchInfo> option) {
		ActionStdV2<FimarchInfo> select = new RootFimarchSelectOwner(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_NOT_FOUND;
	}
}
