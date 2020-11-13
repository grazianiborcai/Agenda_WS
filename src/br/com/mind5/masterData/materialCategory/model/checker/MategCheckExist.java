package br.com.mind5.masterData.materialCategory.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialCategory.model.action.StdMategDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MategCheckExist extends ModelCheckerTemplateActionV2<MategInfo, MategInfo> {
	
	public MategCheckExist(ModelCheckerOption option) {
		super(option, MategInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MategInfo> buildActionHook(DeciTreeOption<MategInfo> option) {
		ActionStdV2<MategInfo> select = new StdMategDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_CATEG_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_CATEG_NOT_FOUND;
	}
}
