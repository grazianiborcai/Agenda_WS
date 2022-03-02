package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiMergeCalonthLtm;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiRootSelect;


public final class SowusRootSelectLtm extends DeciTreeTemplateWrite<SowusInfo> {
	
	public SowusRootSelectLtm(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();
		ModelChecker<SowusInfo> checker;

		checker = new ModelCheckerDummy<SowusInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> mergeCalonthLtm = new ActionStdCommom<SowusInfo>(option, SowusVisiMergeCalonthLtm.class);
		ActionLazy<SowusInfo> select = new ActionLazyCommom<SowusInfo>(option.conn, option.schemaName, SowusVisiRootSelect.class);
		
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
