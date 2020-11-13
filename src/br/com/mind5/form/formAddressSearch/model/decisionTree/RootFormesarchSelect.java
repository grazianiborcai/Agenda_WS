package br.com.mind5.form.formAddressSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.form.formAddressSearch.model.action.StdFormesarchMergeToSelect;
import br.com.mind5.form.formAddressSearch.model.checker.FormesarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFormesarchSelect extends DeciTreeTemplateReadV2<FormesarchInfo> {
	
	public RootFormesarchSelect(DeciTreeOption<FormesarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormesarchInfo> buildCheckerHook(DeciTreeOption<FormesarchInfo> option) {
		List<ModelCheckerV1<FormesarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormesarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FormesarchCheckRead(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FormesarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FormesarchInfo> option) {
		List<ActionStdV2<FormesarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FormesarchInfo> mergeToSelect = new StdFormesarchMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
