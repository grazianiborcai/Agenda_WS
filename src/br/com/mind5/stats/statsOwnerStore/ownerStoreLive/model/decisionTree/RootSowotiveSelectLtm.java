package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.LazySowotiveRootSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.StdSowotiveMergeCalonthLtm;


public final class RootSowotiveSelectLtm extends DeciTreeTemplateWrite<SowotiveInfo> {
	
	public RootSowotiveSelectLtm(DeciTreeOption<SowotiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotiveInfo> buildCheckerHook(DeciTreeOption<SowotiveInfo> option) {
		List<ModelChecker<SowotiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowotiveInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotiveInfo> option) {
		List<ActionStd<SowotiveInfo>> actions = new ArrayList<>();

		ActionStd<SowotiveInfo> mergeCalonthLtm = new StdSowotiveMergeCalonthLtm(option);
		ActionLazy<SowotiveInfo> select = new LazySowotiveRootSelect(option.conn, option.schemaName);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
