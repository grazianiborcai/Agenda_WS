package br.com.mind5.masterData.materialCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.action.MategVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MategCheckExist extends ModelCheckerTemplateAction<MategInfo, MategInfo> {
	
	public MategCheckExist(ModelCheckerOption option) {
		super(option, MategInfo.class);
	}
	
	
	
	@Override protected ActionStd<MategInfo> buildActionHook(DeciTreeOption<MategInfo> option) {
		ActionStd<MategInfo> select = new ActionStdCommom<MategInfo>(option, MategVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_CATEG_NOT_FOUND;
	}
}
