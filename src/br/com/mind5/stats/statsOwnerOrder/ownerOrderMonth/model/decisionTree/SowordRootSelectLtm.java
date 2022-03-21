package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.SowordVisiMergeCalonthLtm;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.SowordVisiMergeStolis;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.SowordVisiRootSelect;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.checker.SowordCheckReadLtm;


public final class SowordRootSelectLtm extends DeciTreeTemplateWrite<SowordInfo> {
	
	public SowordRootSelectLtm(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();
		ModelChecker<SowordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowordCheckReadLtm(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> mergeStolis = new ActionStdCommom<SowordInfo>(option, SowordVisiMergeStolis.class);
		ActionLazy<SowordInfo> mergeCalonthLtm = new ActionLazyCommom<SowordInfo>(option, SowordVisiMergeCalonthLtm.class);
		ActionLazy<SowordInfo> select = new ActionLazyCommom<SowordInfo>(option, SowordVisiRootSelect.class);
		
		mergeStolis.addPostAction(mergeCalonthLtm);
		mergeCalonthLtm.addPostAction(select);
		
		actions.add(mergeStolis);
		return actions;
	}
}
