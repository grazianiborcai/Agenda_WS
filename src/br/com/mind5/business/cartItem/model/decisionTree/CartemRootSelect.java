package br.com.mind5.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.CartemVisiNodeAged;
import br.com.mind5.business.cartItem.model.action.CartemVisiNodeSelect;
import br.com.mind5.business.cartItem.model.action.CartemVisiMergeToSelect;
import br.com.mind5.business.cartItem.model.checker.CartemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class CartemRootSelect extends DeciTreeTemplateWrite<CartemInfo> {
	
	public CartemRootSelect(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CartemCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> select = new ActionStdCommom<CartemInfo>(option, CartemVisiMergeToSelect.class);
		ActionLazy<CartemInfo> nodeSelect = new ActionLazyCommom<CartemInfo>(option, CartemVisiNodeSelect.class);		
		ActionLazy<CartemInfo> nodeAged = new ActionLazyCommom<CartemInfo>(option, CartemVisiNodeAged.class);	
		
		select.addPostAction(nodeSelect);
		nodeSelect.addPostAction(nodeAged);
		
		actions.add(select);
		return actions;
	}
}
