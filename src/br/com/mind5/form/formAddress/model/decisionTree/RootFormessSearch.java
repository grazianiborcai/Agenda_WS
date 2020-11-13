package br.com.mind5.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.LazyFormessRootSelect;
import br.com.mind5.form.formAddress.model.action.StdFormessMergeFormesarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFormessSearch extends DeciTreeTemplateRead<FormessInfo> {
	
	public RootFormessSearch(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormessInfo> buildCheckerHook(DeciTreeOption<FormessInfo> option) {
		List<ModelChecker<FormessInfo>> queue = new ArrayList<>();		
		ModelChecker<FormessInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);		
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormessInfo>> buildActionsOnPassedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStd<FormessInfo>> actions = new ArrayList<>();
		
		ActionStd<FormessInfo> mergeFormesarch = new StdFormessMergeFormesarch(option);
		ActionLazy<FormessInfo> select = new LazyFormessRootSelect(option.conn, option.schemaName);
		
		mergeFormesarch.addPostAction(select);
		
		actions.add(mergeFormesarch);
		return actions;
	}
}
