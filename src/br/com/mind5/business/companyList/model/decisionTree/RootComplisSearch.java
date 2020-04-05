package br.com.mind5.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.action.LazyComplisRootSelect;
import br.com.mind5.business.companyList.model.action.StdComplisMergeComparch;
import br.com.mind5.business.companyList.model.checker.ComplisCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootComplisSearch extends DeciTreeReadTemplate<ComplisInfo> {
	
	public RootComplisSearch(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ComplisInfo> buildCheckerHook(DeciTreeOption<ComplisInfo> option) {
		List<ModelChecker<ComplisInfo>> queue = new ArrayList<>();		
		ModelChecker<ComplisInfo> checker;
	
		checker = new ComplisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<ComplisInfo>> buildActionsOnPassedHook(DeciTreeOption<ComplisInfo> option) {
		List<ActionStdV1<ComplisInfo>> actions = new ArrayList<>();
		
		ActionStdV1<ComplisInfo> mergeComparch = new StdComplisMergeComparch(option);	
		ActionLazyV1<ComplisInfo> select = new LazyComplisRootSelect(option.conn, option.schemaName);
		
		mergeComparch.addPostAction(select);
		
		actions.add(mergeComparch);		
		return actions;
	}
}
