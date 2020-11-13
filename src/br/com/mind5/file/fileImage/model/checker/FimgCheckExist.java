package br.com.mind5.file.fileImage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.action.StdFimgDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgCheckExist extends ModelCheckerTemplateActionV2<FimgInfo, FimgInfo> {	
	
	public FimgCheckExist(ModelCheckerOption option) {
		super(option, FimgInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<FimgInfo> buildActionHook(DeciTreeOption<FimgInfo> option) {
		ActionStdV2<FimgInfo> select = new StdFimgDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_NOT_FOUND;
	}
}
