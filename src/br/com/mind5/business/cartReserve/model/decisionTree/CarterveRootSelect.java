package br.com.mind5.business.cartReserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.action.CarterveVisiEnforceLChanged;
import br.com.mind5.business.cartReserve.model.action.CarterveVisiMergeToSelect;
import br.com.mind5.business.cartReserve.model.checker.CarterveCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CarterveRootSelect extends DeciTreeTemplateRead<CarterveInfo> {
	
	public CarterveRootSelect(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CarterveInfo> buildCheckerHook(DeciTreeOption<CarterveInfo> option) {
		List<ModelChecker<CarterveInfo>> queue = new ArrayList<>();		
		ModelChecker<CarterveInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CarterveCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CarterveInfo>> buildActionsOnPassedHook(DeciTreeOption<CarterveInfo> option) {
		List<ActionStd<CarterveInfo>> actions = new ArrayList<>();	
		
		ActionStd<CarterveInfo> enforceLChanged = new ActionStdCommom<CarterveInfo>(option, CarterveVisiEnforceLChanged.class);
		ActionLazy<CarterveInfo> select = new ActionLazyCommom<CarterveInfo>(option, CarterveVisiMergeToSelect.class);
		
		enforceLChanged.addPostAction(select);
		
		actions.add(enforceLChanged);			
		return actions;
	}
}
