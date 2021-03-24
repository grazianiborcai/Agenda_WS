package br.com.mind5.file.sysFileImage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImage.model.action.StdFimgysDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysCheckExist extends ModelCheckerTemplateAction<FimgysInfo, FimgysInfo> {	
	
	public FimgysCheckExist(ModelCheckerOption option) {
		super(option, FimgysInfo.class);
	}
	
	
	
	@Override protected ActionStd<FimgysInfo> buildActionHook(DeciTreeOption<FimgysInfo> option) {
		ActionStd<FimgysInfo> select = new StdFimgysDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_NOT_FOUND;
	}
}
