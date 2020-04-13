package br.com.mind5.business.form.formAddressSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddressSearch.info.FormesarchInfo;
import br.com.mind5.business.form.formAddressSearch.model.action.StdFormesarchMergeToSelect;
import br.com.mind5.business.form.formAddressSearch.model.checker.FormesarchCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootFormesarchSelect extends DeciTreeTemplateReadV1<FormesarchInfo> {
	
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
	
	
	
	@Override protected List<ActionStdV1<FormesarchInfo>> buildActionsOnPassedHook(DeciTreeOption<FormesarchInfo> option) {
		List<ActionStdV1<FormesarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FormesarchInfo> mergeToSelect = new StdFormesarchMergeToSelect(option);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
