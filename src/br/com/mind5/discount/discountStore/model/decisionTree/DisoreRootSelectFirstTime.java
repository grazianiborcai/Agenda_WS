package br.com.mind5.discount.discountStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiRootSelect;
import br.com.mind5.discount.discountStore.model.action.DisoreVisiMergeDisorarchFirstTime;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class DisoreRootSelectFirstTime extends DeciTreeTemplateRead<DisoreInfo> {
	
	public DisoreRootSelectFirstTime(DeciTreeOption<DisoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisoreInfo> buildCheckerHook(DeciTreeOption<DisoreInfo> option) {
		List<ModelChecker<DisoreInfo>> queue = new ArrayList<>();		
		ModelChecker<DisoreInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisoreInfo>> buildActionsOnPassedHook(DeciTreeOption<DisoreInfo> option) {
		List<ActionStd<DisoreInfo>> actions = new ArrayList<>();
		
		ActionStd<DisoreInfo> search = new ActionStdCommom<DisoreInfo>(option, DisoreVisiMergeDisorarchFirstTime.class);
		ActionLazy<DisoreInfo> select = new ActionLazyCommom<DisoreInfo>(option, DisoreVisiRootSelect.class);
		
		search.addPostAction(select);
		
		actions.add(search);
		return actions;
	}
}
