package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.StdFimgSelect;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgCheckExist extends ModelCheckerTemplateAction<FimgInfo, FimgInfo> {	
	
	public FimgCheckExist(ModelCheckerOption option) {
		super(option, FimgInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<FimgInfo> buildActionHook(DeciTreeOption<FimgInfo> option) {
		ActionStdV1<FimgInfo> select = new StdFimgSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_NOT_FOUND;
	}
}
