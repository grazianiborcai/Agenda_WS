package br.com.mind5.file.sysFileImageSearch.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.file.sysFileImageSearch.model.decisionTree.FimgysarchRootSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class FimgysarchCheckExist extends ModelCheckerTemplateAction<FimgysarchInfo, FimgysarchInfo> {	
	
	public FimgysarchCheckExist(ModelCheckerOption option) {
		super(option, FimgysarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<FimgysarchInfo> buildActionHook(DeciTreeOption<FimgysarchInfo> option) {
		ActionStd<FimgysarchInfo> select = new FimgysarchRootSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.SYS_FILE_IMG_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_SEARCH_NOT_FOUND;
	}
}
