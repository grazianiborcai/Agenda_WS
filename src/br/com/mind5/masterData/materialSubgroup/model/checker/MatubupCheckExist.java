package br.com.mind5.masterData.materialSubgroup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.StdMatubupDaoSelect;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupCheckExist extends ModelCheckerTemplateActionV2<MatubupInfo, MatubupInfo> {
	
	public MatubupCheckExist(ModelCheckerOption option) {
		super(option, MatubupInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<MatubupInfo> buildActionHook(DeciTreeOption<MatubupInfo> option) {
		ActionStdV2<MatubupInfo> select = new StdMatubupDaoSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_SUBGROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SUBGROUP_NOT_FOUND;
	}
}
