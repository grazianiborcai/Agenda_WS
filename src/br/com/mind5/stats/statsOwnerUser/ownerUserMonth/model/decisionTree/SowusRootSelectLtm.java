package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiMergeCalonthLtm;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiMergeStolis;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiRootSelect;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.checker.SowusCheckReadLtm;


public final class SowusRootSelectLtm extends DeciTreeTemplateWrite<SowusInfo> {
	
	public SowusRootSelectLtm(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();
		ModelChecker<SowusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowusCheckReadLtm(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd <SowusInfo> mergeStolis     = new ActionStdCommom <SowusInfo>(option, SowusVisiMergeStolis.class);
		ActionLazy<SowusInfo> mergeCalonthLtm = new ActionLazyCommom<SowusInfo>(option, SowusVisiMergeCalonthLtm.class);
		ActionLazy<SowusInfo> select          = new ActionLazyCommom<SowusInfo>(option, SowusVisiRootSelect.class);
		
		mergeStolis.addPostAction(mergeCalonthLtm);
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeStolis);
		return actions;
	}
}
