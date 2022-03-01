package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.SowotiveVisiMergeCalonthLtm;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action.SowotiveVisiRootSelect;


public final class SowotiveRootSelectLtm extends DeciTreeTemplateWrite<SowotiveInfo> {
	
	public SowotiveRootSelectLtm(DeciTreeOption<SowotiveInfo> option) {
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

		ActionStd<SowotiveInfo> mergeCalonthLtm = new ActionStdCommom<SowotiveInfo>(option, SowotiveVisiMergeCalonthLtm.class);
		ActionLazy<SowotiveInfo> select = new ActionLazyCommom<SowotiveInfo>(option.conn, option.schemaName, SowotiveVisiRootSelect.class);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
