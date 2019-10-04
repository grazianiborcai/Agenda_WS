package br.com.gda.file.fileImage.model.checker;

import br.com.gda.common.SystemCode;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.file.fileImageSearch.model.decisionTree.RootFimarchSelectStore;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateActionV2;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FimgCheckLimitStore extends ModelCheckerTemplateActionV2<FimgInfo, FimarchInfo> {
	private final int MAX_RECORD_COUNT = 10;
	
	
	public FimgCheckLimitStore(ModelCheckerOption option) {
		super(option, FimarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<FimarchInfo> buildActionHook(DeciTreeOption<FimarchInfo> option) {
		ActionStd<FimarchInfo> select = new RootFimarchSelectStore(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getMaxCountHook() {
		return MAX_RECORD_COUNT;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.FILE_IMG_LIMIT_NOT_REACHED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_LIMIT_EXCEEDED;
	}
}
