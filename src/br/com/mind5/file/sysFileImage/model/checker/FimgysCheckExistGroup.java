package br.com.mind5.file.sysFileImage.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.decisionTree.FimgysarchRootSelectGroup;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysCheckExistGroup extends ModelCheckerTemplateAction<FimgysInfo, FimgysarchInfo> {	
	
	public FimgysCheckExistGroup(ModelCheckerOption option) {
		super(option, FimgysarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<FimgysarchInfo> buildActionHook(DeciTreeOption<FimgysarchInfo> option) {
		ActionStd<FimgysarchInfo> select = new FimgysarchRootSelectGroup(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_FILE_IMG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_NOT_FOUND;
	}
}
