package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action.SowotVisiMergeCalonthLtm;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action.SowotVisiRootSelect;


public final class SowotRootSelectLtm extends DeciTreeTemplateWrite<SowotInfo> {
	
	public SowotRootSelectLtm(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotInfo> buildCheckerHook(DeciTreeOption<SowotInfo> option) {
		List<ModelChecker<SowotInfo>> queue = new ArrayList<>();
		ModelChecker<SowotInfo> checker;

		checker = new ModelCheckerDummy<SowotInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd<SowotInfo> mergeCalonthLtm = new ActionStdCommom<SowotInfo>(option, SowotVisiMergeCalonthLtm.class);
		ActionLazy<SowotInfo> select = new ActionLazyCommom<SowotInfo>(option.conn, option.schemaName, SowotVisiRootSelect.class);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
