package br.com.mind5.masterData.refundPolicyGroupItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.LazyRefugritemRootSelect;
import br.com.mind5.masterData.refundPolicyGroupItem.model.action.StdRefugritemMergeRefugritarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugritemSearch extends DeciTreeTemplateReadV2<RefugritemInfo> {
	
	public RootRefugritemSearch(DeciTreeOption<RefugritemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugritemInfo> buildCheckerHook(DeciTreeOption<RefugritemInfo> option) {
		List<ModelCheckerV1<RefugritemInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugritemInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<RefugritemInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugritemInfo> option) {
		List<ActionStdV2<RefugritemInfo>> actions = new ArrayList<>();
		
		ActionStdV2<RefugritemInfo> mergeRefugritarch = new StdRefugritemMergeRefugritarch(option);
		ActionLazy<RefugritemInfo> select = new LazyRefugritemRootSelect(option.conn, option.schemaName);
		
		mergeRefugritarch.addPostAction(select);
		
		actions.add(mergeRefugritarch);
		return actions;
	}
}
