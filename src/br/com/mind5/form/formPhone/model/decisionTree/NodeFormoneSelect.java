package br.com.mind5.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.action.StdFormoneDaoSelect;
import br.com.mind5.form.formPhone.model.action.StdFormoneEnforceDefault;
import br.com.mind5.form.formPhone.model.checker.FormoneCheckExist;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeFormoneSelect extends DeciTreeTemplateReadV2<FormoneInfo> {
	
	public NodeFormoneSelect(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormoneInfo> buildCheckerHook(DeciTreeOption<FormoneInfo> option) {
		List<ModelCheckerV1<FormoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormoneCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FormoneInfo>> buildActionsOnPassedHook(DeciTreeOption<FormoneInfo> option) {
		List<ActionStdV2<FormoneInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FormoneInfo> select = new StdFormoneDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<FormoneInfo>> buildActionsOnFailedHook(DeciTreeOption<FormoneInfo> option) {
		List<ActionStdV2<FormoneInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FormoneInfo> enforceDefault = new StdFormoneEnforceDefault(option);
		
		actions.add(enforceDefault);
		return actions;
	}
}
