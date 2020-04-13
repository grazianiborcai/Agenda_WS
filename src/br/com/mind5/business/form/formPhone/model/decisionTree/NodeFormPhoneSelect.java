package br.com.mind5.business.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.business.form.formPhone.model.action.StdFormPhoneEnforceDefault;
import br.com.mind5.business.form.formPhone.model.action.StdFormPhoneSelect;
import br.com.mind5.business.form.formPhone.model.checker.FormPhoneCheckExist;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class NodeFormPhoneSelect extends DeciTreeTemplateReadV1<FormPhoneInfo> {
	
	public NodeFormPhoneSelect(DeciTreeOption<FormPhoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormPhoneInfo> buildCheckerHook(DeciTreeOption<FormPhoneInfo> option) {
		List<ModelCheckerV1<FormPhoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormPhoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormPhoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FormPhoneInfo>> buildActionsOnPassedHook(DeciTreeOption<FormPhoneInfo> option) {
		List<ActionStdV1<FormPhoneInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FormPhoneInfo> select = new StdFormPhoneSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<FormPhoneInfo>> buildActionsOnFailedHook(DeciTreeOption<FormPhoneInfo> option) {
		List<ActionStdV1<FormPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormPhoneEnforceDefault(option));
		return actions;
	}
}
