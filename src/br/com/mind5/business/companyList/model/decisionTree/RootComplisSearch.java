package br.com.mind5.business.companyList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.companyList.model.action.LazyComplisRootSelect;
import br.com.mind5.business.companyList.model.action.StdComplisMergeComparch;
import br.com.mind5.business.companyList.model.checker.ComplisCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootComplisSearch extends DeciTreeTemplateRead<ComplisInfo> {
	
	public RootComplisSearch(DeciTreeOption<ComplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<ComplisInfo> buildCheckerHook(DeciTreeOption<ComplisInfo> option) {
		List<ModelCheckerV1<ComplisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<ComplisInfo> checker;
	
		checker = new ComplisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
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
