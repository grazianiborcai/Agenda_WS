package br.com.mind5.business.refundPolicyStoreSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.model.action.StdRefupowarchMergeToSelect;
import br.com.mind5.business.refundPolicyStoreSearch.model.checker.RefuporarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefuporarchSelect extends DeciTreeTemplateRead<RefuporarchInfo> {
	
	public RootRefuporarchSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuporarchInfo> buildCheckerHook(DeciTreeOption<RefuporarchInfo> option) {
		List<ModelChecker<RefuporarchInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuporarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuporarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuporarchInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporarchInfo> option) {
		List<ActionStd<RefuporarchInfo>> actions = new ArrayList<>();
		
		ActionStd<RefuporarchInfo> select = new StdRefupowarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
