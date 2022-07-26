package br.com.mind5.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.FormessVisiRootSelect;
import br.com.mind5.form.formAddress.model.action.FormessVisiMergeFormesarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class FormessRootSearch extends DeciTreeTemplateRead<FormessInfo> {
	
	public FormessRootSearch(DeciTreeOption<FormessInfo> option) {
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
		
		ActionStd<FormessInfo> mergeFormesarch = new ActionStdCommom<FormessInfo>(option, FormessVisiMergeFormesarch.class);
		ActionLazy<FormessInfo> select = new ActionLazyCommom<FormessInfo>(option, FormessVisiRootSelect.class);
		
		mergeFormesarch.addPostAction(select);
		
		actions.add(mergeFormesarch);
		return actions;
	}
}
