package br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.LazyRefugritemRootSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.StdRefugritemMergeRefugritarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefugritemSearch extends DeciTreeTemplateRead<RefugritemInfo> {
	
	public RootRefugritemSearch(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefugritemInfo> buildCheckerHook(DeciTreeOption<RefugritemInfo> option) {
		List<ModelChecker<RefugritemInfo>> queue = new ArrayList<>();		
		ModelChecker<RefugritemInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefugritemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugritemInfo> option) {
		List<ActionStd<RefugritemInfo>> actions = new ArrayList<>();
		
		ActionStd<RefugritemInfo> mergeRefugritarch = new StdRefugritemMergeRefugritarch(option);
		ActionLazy<RefugritemInfo> select = new LazyRefugritemRootSelect(option.conn, option.schemaName);
		
		mergeRefugritarch.addPostAction(select);
		
		actions.add(mergeRefugritarch);
		return actions;
	}
}
