package br.com.mind5.business.cartReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.action.LazyCarterveMergeToSelect;
import br.com.mind5.business.cartReserve.model.action.StdCarterveEnforceLChanged;
import br.com.mind5.business.cartReserve.model.checker.CarterveCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootCarterveSelect extends DeciTreeReadTemplate<CarterveInfo> {
	
	public RootCarterveSelect(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CarterveInfo> buildDecisionCheckerHook(DeciTreeOption<CarterveInfo> option) {
		List<ModelChecker<CarterveInfo>> queue = new ArrayList<>();		
		ModelChecker<CarterveInfo> checker;	
		
		checker = new CarterveCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CarterveInfo>> buildActionsOnPassedHook(DeciTreeOption<CarterveInfo> option) {
		List<ActionStd<CarterveInfo>> actions = new ArrayList<>();	
		
		ActionStd<CarterveInfo> enforceLChanged = new StdCarterveEnforceLChanged(option);
		ActionLazy<CarterveInfo> select = new LazyCarterveMergeToSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(select);
		
		actions.add(enforceLChanged);			
		return actions;
	}
}
