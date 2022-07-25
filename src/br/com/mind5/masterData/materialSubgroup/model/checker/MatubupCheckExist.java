package br.com.mind5.masterData.materialSubgroup.model.checker;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialSubgroup.model.action.MatubupVisiDaoSelect;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatubupCheckExist extends ModelCheckerTemplateAction<MatubupInfo, MatubupInfo> {
	
	public MatubupCheckExist(ModelCheckerOption option) {
		super(option, MatubupInfo.class);
	}
	
	
	
	@Override protected ActionStd<MatubupInfo> buildActionHook(DeciTreeOption<MatubupInfo> option) {
		ActionStd<MatubupInfo> select = new ActionStdCommom<MatubupInfo>(option, MatubupVisiDaoSelect.class);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.MAT_SUBGROUP_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SUBGROUP_NOT_FOUND;
	}
}
