package br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.decisionTree;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.info.CutefilonInfo;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action.CutefilonVisiMergeCalonthNow;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonth.model.action.CutefilonVisiRootSelect;


public final class CutefilonRootSelectNow extends DeciTreeTemplateWrite<CutefilonInfo> {
	
	public CutefilonRootSelectNow(DeciTreeOption<CutefilonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CutefilonInfo> buildCheckerHook(DeciTreeOption<CutefilonInfo> option) {
		List<ModelChecker<CutefilonInfo>> queue = new ArrayList<>();		
		ModelChecker<CutefilonInfo> checker;
		
		checker = new ModelCheckerDummy<CutefilonInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CutefilonInfo>> buildActionsOnPassedHook(DeciTreeOption<CutefilonInfo> option) {
		List<ActionStd<CutefilonInfo>> actions = new ArrayList<>();

		ActionStd<CutefilonInfo> mergeCalonthNow = new ActionStdCommom<CutefilonInfo>(option, CutefilonVisiMergeCalonthNow.class);
		ActionLazy<CutefilonInfo> select = new ActionLazyCommom<CutefilonInfo>(option, CutefilonVisiRootSelect.class);
		
		mergeCalonthNow.addPostAction(select);
		
		actions.add(mergeCalonthNow);
		return actions;
	}
}
