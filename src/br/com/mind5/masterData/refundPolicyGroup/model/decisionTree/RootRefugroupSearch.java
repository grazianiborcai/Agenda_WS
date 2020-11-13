package br.com.mind5.masterData.refundPolicyGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.action.LazyRefugroupRootSelect;
import br.com.mind5.masterData.refundPolicyGroup.model.action.StdRefugroupMergeRefugrarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefugroupSearch extends DeciTreeTemplateRead<RefugroupInfo> {
	
	public RootRefugroupSearch(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefugroupInfo> buildCheckerHook(DeciTreeOption<RefugroupInfo> option) {
		List<ModelChecker<RefugroupInfo>> queue = new ArrayList<>();		
		ModelChecker<RefugroupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefugroupInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugroupInfo> option) {
		List<ActionStd<RefugroupInfo>> actions = new ArrayList<>();
		
		ActionStd<RefugroupInfo> mergeRefugrarch = new StdRefugroupMergeRefugrarch(option);
		ActionLazy<RefugroupInfo> select = new LazyRefugroupRootSelect(option.conn, option.schemaName);
		
		mergeRefugrarch.addPostAction(select);
		
		actions.add(mergeRefugrarch);
		return actions;
	}
}
