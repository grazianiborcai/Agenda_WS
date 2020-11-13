package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeMergeRefupown;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeRefuporeFallback extends DeciTreeTemplateRead<RefuporeInfo> {
	
	public NodeRefuporeFallback(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuporeInfo> buildCheckerHook(DeciTreeOption<RefuporeInfo> option) {
		List<ModelChecker<RefuporeInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuporeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuporeCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStd<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStd<RefuporeInfo> select = new NodeRefuporeSelect(option).toAction();
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<RefuporeInfo>> buildActionsOnFailedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStd<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStd<RefuporeInfo> mergeRefupown = new StdRefuporeMergeRefupown(option);
		
		actions.add(mergeRefupown);
		return actions;
	}
}
