package br.com.mind5.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.action.ComplisVisiRootSelect;
import br.com.mind5.business.companyList.model.action.ComplisVisiMergeComparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class ComplisRootSearch extends DeciTreeTemplateRead<ComplisInfo> {
	
	public ComplisRootSearch(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComplisInfo> buildCheckerHook(DeciTreeOption<ComplisInfo> option) {
		List<ModelChecker<ComplisInfo>> queue = new ArrayList<>();		
		ModelChecker<ComplisInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ComplisInfo>> buildActionsOnPassedHook(DeciTreeOption<ComplisInfo> option) {
		List<ActionStd<ComplisInfo>> actions = new ArrayList<>();
		
		ActionStd<ComplisInfo> mergeComparch = new ActionStdCommom<ComplisInfo>(option, ComplisVisiMergeComparch.class);	
		ActionLazy<ComplisInfo> select = new ActionLazyCommom<ComplisInfo>(option, ComplisVisiRootSelect.class);
		
		mergeComparch.addPostAction(select);
		
		actions.add(mergeComparch);		
		return actions;
	}
}
