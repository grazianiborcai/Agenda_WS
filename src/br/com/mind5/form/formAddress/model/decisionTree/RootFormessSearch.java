package br.com.mind5.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.LazyFormessRootSelect;
import br.com.mind5.form.formAddress.model.action.StdFormessMergeFormesarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFormessSearch extends DeciTreeTemplateReadV2<FormessInfo> {
	
	public RootFormessSearch(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormessInfo> buildCheckerHook(DeciTreeOption<FormessInfo> option) {
		List<ModelCheckerV1<FormessInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormessInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);		
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FormessInfo>> buildActionsOnPassedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStdV1<FormessInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FormessInfo> mergeFormesarch = new StdFormessMergeFormesarch(option);
		ActionLazy<FormessInfo> select = new LazyFormessRootSelect(option.conn, option.schemaName);
		
		mergeFormesarch.addPostAction(select);
		
		actions.add(mergeFormesarch);
		return actions;
	}
}
