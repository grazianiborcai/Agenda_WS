package br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.info.StoronInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiRootSelect;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonth.model.action.StoronVisiMergeCalonthLtm;


public final class StoronRootSelectLtm extends DeciTreeTemplateWrite<StoronInfo> {
	
	public StoronRootSelectLtm(DeciTreeOption<StoronInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoronInfo> buildCheckerHook(DeciTreeOption<StoronInfo> option) {
		List<ModelChecker<StoronInfo>> queue = new ArrayList<>();
		ModelChecker<StoronInfo> checker;

		checker = new ModelCheckerDummy<StoronInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoronInfo>> buildActionsOnPassedHook(DeciTreeOption<StoronInfo> option) {
		List<ActionStd<StoronInfo>> actions = new ArrayList<>();

		ActionStd<StoronInfo> mergeCalonthLtm = new ActionStdCommom<StoronInfo>(option, StoronVisiMergeCalonthLtm.class);
		ActionLazy<StoronInfo> select = new ActionLazyCommom<StoronInfo>(option, StoronVisiRootSelect.class);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
