package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree;

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
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action.StefilonVisiMergeCalonthNow;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action.StefilonVisiRootSelect;


public final class StefilonRootSelectNow extends DeciTreeTemplateWrite<StefilonInfo> {
	
	public StefilonRootSelectNow(DeciTreeOption<StefilonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefilonInfo> buildCheckerHook(DeciTreeOption<StefilonInfo> option) {
		List<ModelChecker<StefilonInfo>> queue = new ArrayList<>();		
		ModelChecker<StefilonInfo> checker;
		
		checker = new ModelCheckerDummy<StefilonInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<StefilonInfo> option) {
		List<ActionStd<StefilonInfo>> actions = new ArrayList<>();

		ActionStd<StefilonInfo> mergeCalonthNow = new ActionStdCommom<StefilonInfo>(option, StefilonVisiMergeCalonthNow.class);
		ActionLazy<StefilonInfo> select = new ActionLazyCommom<StefilonInfo>(option, StefilonVisiRootSelect.class);
		
		mergeCalonthNow.addPostAction(select);
		
		actions.add(mergeCalonthNow);
		return actions;
	}
}
