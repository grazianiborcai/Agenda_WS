package br.com.mind5.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.StdFormessEnforceDefault;
import br.com.mind5.form.formAddress.model.action.StdFormessMergeToSelect;
import br.com.mind5.form.formAddress.model.checker.FormessCheckExist;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeFormessSelect extends DeciTreeTemplateWriteV2<FormessInfo> {
	
	public NodeFormessSelect(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormessInfo> buildCheckerHook(DeciTreeOption<FormessInfo> option) {
		List<ModelCheckerV1<FormessInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormessInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormessCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FormessInfo>> buildActionsOnPassedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStdV2<FormessInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FormessInfo> select = new StdFormessMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<FormessInfo>> buildActionsOnFailedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStdV2<FormessInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FormessInfo> enforceDefault = new StdFormessEnforceDefault(option);
		
		actions.add(enforceDefault);
		return actions;
	}
}
