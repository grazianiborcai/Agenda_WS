package br.com.mind5.form.formPhone.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.form.formPhone.model.checker.FormoneCheckCountry;
import br.com.mind5.form.formPhone.model.checker.FormoneCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFormoneSelect extends DeciTreeTemplateReadV2<FormoneInfo> {
	
	public RootFormoneSelect(DeciTreeOption<FormoneInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormoneInfo> buildCheckerHook(DeciTreeOption<FormoneInfo> option) {
		List<ModelCheckerV1<FormoneInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormoneInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FormoneCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormoneCheckCountry(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FormoneInfo>> buildActionsOnPassedHook(DeciTreeOption<FormoneInfo> option) {
		List<ActionStdV1<FormoneInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FormoneInfo> nodeSelect = new NodeFormoneSelect(option).toAction();
		
		actions.add(nodeSelect);
		return actions;
	}
}
