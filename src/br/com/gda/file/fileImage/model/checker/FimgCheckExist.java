package br.com.gda.file.fileImage.model.checker;

import br.com.gda.common.SystemCode;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.action.StdFimgSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgCheckExist extends ModelCheckerTemplateActionV2<FimgInfo, FimgInfo> {	
	
	public FimgCheckExist(ModelCheckerOption option) {
		super(option, FimgInfo.class);
	}
	
	
	
	@Override protected ActionStd<FimgInfo> buildActionHook(DeciTreeOption<FimgInfo> option) {
		ActionStd<FimgInfo> select = new StdFimgSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_NOT_FOUND;
	}
}
