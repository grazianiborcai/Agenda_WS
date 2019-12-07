package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelectMat;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgCheckExistMat extends ModelCheckerTemplateActionV2<FimgInfo, FimarchInfo> {	
	
	public FimgCheckExistMat(ModelCheckerOption option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<FimarchInfo> buildActionHook(DeciTreeOption<FimarchInfo> option) {
		ActionStd<FimarchInfo> select = new RootFimarchSelectMat(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_NOT_FOUND;
	}
}
