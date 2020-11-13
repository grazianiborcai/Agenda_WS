package br.com.mind5.masterData.refundPolicyGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.action.LazyRefugroupMergeRefugritem;
import br.com.mind5.masterData.refundPolicyGroup.model.action.StdRefugroupDaoSelect;
import br.com.mind5.masterData.refundPolicyGroup.model.checker.RefugroupCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefugroupSelect extends DeciTreeTemplateRead<RefugroupInfo> {
	
	public RootRefugroupSelect(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefugroupInfo> buildCheckerHook(DeciTreeOption<RefugroupInfo> option) {
		List<ModelChecker<RefugroupInfo>> queue = new ArrayList<>();		
		ModelChecker<RefugroupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefugroupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefugroupInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugroupInfo> option) {
		List<ActionStd<RefugroupInfo>> actions = new ArrayList<>();
		
		ActionStd<RefugroupInfo> select = new StdRefugroupDaoSelect(option);
		ActionLazy<RefugroupInfo> mergeRefugritem = new LazyRefugroupMergeRefugritem(option.conn, option.schemaName);
		
		select.addPostAction(mergeRefugritem);
		
		actions.add(select);
		return actions;
	}
}
