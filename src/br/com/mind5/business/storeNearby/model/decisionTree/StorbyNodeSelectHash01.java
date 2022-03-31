package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiRootSelectDistrict;
import br.com.mind5.business.storeNearby.model.action.StorbyVisiMergeSysdistr;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckExist50km;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class StorbyNodeSelectHash01 extends DeciTreeTemplateRead<StorbyInfo> {
	
	public StorbyNodeSelectHash01(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelChecker<StorbyInfo>> queue = new ArrayList<>();		
		ModelChecker<StorbyInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorbyCheckExist50km(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> select50km = new StorbyRootSelect50km(option).toAction();
		
		actions.add(select50km);			
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StorbyInfo>> buildActionsOnFailedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStd<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStd<StorbyInfo> mergeSysdistr = new ActionStdCommom<StorbyInfo>(option, StorbyVisiMergeSysdistr.class);
		ActionLazy<StorbyInfo> selectDistrict = new ActionLazyCommom<StorbyInfo>(option, StorbyVisiRootSelectDistrict.class);
		
		mergeSysdistr.addPostAction(selectDistrict);
		
		actions.add(mergeSysdistr);			
		return actions;
	}
}
